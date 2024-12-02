package com.github.clovisgargione.quarkussocial.adapters.in.controller.response;

public class FieldError {

	private String field;

	private String message;

	public FieldError() {
		super();
	}

	public FieldError(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
