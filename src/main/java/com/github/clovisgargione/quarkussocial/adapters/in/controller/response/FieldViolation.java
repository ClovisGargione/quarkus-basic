package com.github.clovisgargione.quarkussocial.adapters.in.controller.response;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;

public class FieldViolation {
	
	public static final int UNPROCESSABLE_ENTITY_STATUS = 422;

	public static<T> Response verifyViolations(Set<ConstraintViolation<T>> violations){
		return ResponseError.createFromValidation(violations).withStatusCode(UNPROCESSABLE_ENTITY_STATUS);
	}
}
