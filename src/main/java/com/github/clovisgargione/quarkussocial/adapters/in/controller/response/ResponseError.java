package com.github.clovisgargione.quarkussocial.adapters.in.controller.response;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;

public class ResponseError {

	private String message;

	private List<FieldError> errors;

	public ResponseError() {
		super();
	}

	public ResponseError(String message, List<FieldError> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}

	public static <T> ResponseError createFromValidation(Set<ConstraintViolation<T>> violations) {
		List<FieldError> errors = violations.stream()
				.map(cv -> new FieldError(cv.getPropertyPath().toString(), cv.getMessage()))
				.collect(Collectors.toList());
		String message = "Erros de validação";

		return new ResponseError(message, errors);

	}
	
	public Response withStatusCode(int code) {
		return Response.status(code).entity(this).build();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}
}
