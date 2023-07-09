package com.micro1service.user.service.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -8944760250566617847L;
	
	private final HttpStatus httpStatus;
	
	public ResourceNotFoundException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
		
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
