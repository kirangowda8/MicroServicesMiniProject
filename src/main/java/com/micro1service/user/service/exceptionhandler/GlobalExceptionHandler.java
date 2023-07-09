package com.micro1service.user.service.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1626133608185983853L;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		ErrorResponse response = ErrorResponse.builder().timeStamp(new Date()).message(exception.getMessage())
				.status(exception.getHttpStatus()).details(request.getDescription(false)).build();
		// ErrorResponse response=new ErrorResponse(new
		// Date(),exception.getMessage(),exception.getHttpStatus(),request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
}
