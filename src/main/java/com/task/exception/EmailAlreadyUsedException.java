package com.task.exception;


public class EmailAlreadyUsedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyUsedException() {
		super("Email already used");
	}
	
}
