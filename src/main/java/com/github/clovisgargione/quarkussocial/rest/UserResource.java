package com.github.clovisgargione.quarkussocial.rest;

import com.github.clovisgargione.quarkussocial.rest.dto.CreateUserRequest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {

    @POST
    public Response createUser(CreateUserRequest userRequest) {
	System.out.println(userRequest.getName());
	return Response.ok(userRequest).build();
    }
}
