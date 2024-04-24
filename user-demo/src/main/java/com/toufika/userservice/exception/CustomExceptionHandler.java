package com.toufika.userservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> resourceNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails ErrorDetails= new ErrorDetails();
		ErrorDetails.setTimestamp(LocalDateTime.now());
		ErrorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		ErrorDetails.setError("RESOURCE_NOT_FOUND");
		ErrorDetails.setMessage(ex.getMessage());
		ErrorDetails.setPath(request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ErrorDetails,HttpStatus.NOT_FOUND);
		
		
	}
	
}
