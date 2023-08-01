package com.webhook.exceptions;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3275578124803143824L;

	public NotFoundException(String msg) {
		super(String.format("Not Found : '%s'", msg));
	}
}