package com.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptions extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6292138291282186426L;

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException exception) {
		return new ResponseEntity<>("Data Access is Empty / ERROR: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> NoSuchElementExceptionHandler(NoSuchElementException exception) {
		return new ResponseEntity<>("Id/Element not found / ERROR: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchFieldError.class)
	public ResponseEntity<String> NoSuchFieldErrorHandler(NoSuchFieldError exception) {
		return new ResponseEntity<>("Please check the Input of the Field / ERROR :" + exception.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

}
