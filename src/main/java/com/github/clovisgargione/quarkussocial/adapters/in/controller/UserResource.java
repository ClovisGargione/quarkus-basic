package com.github.clovisgargione.quarkussocial.adapters.in.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.reactive.RestResponse.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.clovisgargione.quarkussocial.adapters.in.controller.mapper.UserMapper;
import com.github.clovisgargione.quarkussocial.adapters.in.controller.request.UserRequest;
import com.github.clovisgargione.quarkussocial.adapters.in.controller.response.FieldViolation;
import com.github.clovisgargione.quarkussocial.adapters.in.controller.response.UserResponse;
import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.in.DeleteUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.in.FindByIdUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.in.InsertUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.in.ListUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.in.UpdateUserInputPort;

import io.quarkus.security.Authenticated;
import io.vertx.core.http.HttpServerRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("users")
@Authenticated
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	private InsertUserInputPort insertUserInputPort;

	private ListUserInputPort listUserInputPort;

	private DeleteUserInputPort deleteUserInputPort;

	private UpdateUserInputPort updateUserInputPort;
	
	private FindByIdUserInputPort findByIdUserInputPort;

	private UserMapper userMapper;
	
	private Validator validator;
	
	private JsonWebToken jsonWebToken;
	
	@Inject
	public UserResource(InsertUserInputPort insertUserInputPort, ListUserInputPort listUserInputPort,
			DeleteUserInputPort deleteUserInputPort, UpdateUserInputPort updateUserInputPort, FindByIdUserInputPort findByIdUserInputPort, UserMapper userMapper, Validator validator, JsonWebToken jsonWebToken) {
		super();
		this.insertUserInputPort = insertUserInputPort;
		this.listUserInputPort = listUserInputPort;
		this.deleteUserInputPort = deleteUserInputPort;
		this.updateUserInputPort = updateUserInputPort;
		this.findByIdUserInputPort = findByIdUserInputPort;
		this.userMapper = userMapper;
		this.validator = validator;
		this.jsonWebToken = jsonWebToken;
	}

	@POST
	@RolesAllowed({"admin"})
	public Response createUser(UserRequest userRequest) {
		Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest);
		if(!violations.isEmpty()) {
			return FieldViolation.verifyViolations(violations);
		}
		
		var user = userMapper.toUser(userRequest);
		var newUser = insertUserInputPort.insert(user);
		return Response.status(Status.CREATED).entity(newUser).build();
	}

	@GET
	@RolesAllowed({"user"})
	public Response listAllUsers() {
		List<User> users = listUserInputPort.listUsers();
		List<UserResponse> response = users.stream().map(u -> userMapper.toUserResponse(u))
				.collect(Collectors.toList());
		return Response.ok(response).build();
	}

	@DELETE
	@Path("{id}")
	@RolesAllowed({"admin"})
	public Response deleteUser(@PathParam("id") Long id) {
		try {
			deleteUserInputPort.delete(id);
			return Response.noContent().build();
		} catch (UserException e) {
			logger.error(e.getMessage());
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("{id}")
	@RolesAllowed({"admin"})
	public Response updateUser(@PathParam("id") Long id, UserRequest userRequest) {
		Set<ConstraintViolation<UserRequest>> violations = validator.validate(userRequest);
		if(!violations.isEmpty()) {
			return FieldViolation.verifyViolations(violations);
		}
		User user = userMapper.toUser(userRequest);
		try {
			User userUpdated = updateUserInputPort.update(id, user);
			UserResponse response = userMapper.toUserResponse(userUpdated);
			return Response.ok(response).build();
		} catch (UserException e) {
			logger.error(e.getMessage());
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("{id}")
	@RolesAllowed({"user"})
	public Response findByIdUser(@PathParam("id") Long id) {
		try {
			User user = findByIdUserInputPort.findById(id);
			UserResponse response = userMapper.toUserResponse(user);
			return Response.ok(response).build();
		} catch (UserException e) {
			logger.error(e.getMessage());
		}
		return Response.status(Status.NOT_FOUND).entity("Usuário não encontrado").build();
	}
	
	@GET
	@Path("host")
	@RolesAllowed({"user"})
	public Response getHost(@Context HttpServerRequest serverRequest) throws UnknownHostException {
		
		String hostAndPort = InetAddress.getLocalHost().getHostName() + ":" + serverRequest.localAddress().port();
		return Response.ok(hostAndPort).build();
	}
}
