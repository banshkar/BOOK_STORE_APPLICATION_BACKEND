package com.bridgelabz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyAdviceException {
     
	
	@ExceptionHandler(ExistException.class)
	public ResponseEntity<Object> getRespo(ExistException exception){
		String message =exception.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
	}
	
}
