package com.demo.brandbacks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID= 1L;
	
	public ResourceNotFoundException(String type, Long id) {
		super("Type: "+ type +"id:"+ id);
	}
	
	public ResourceNotFoundException(String type , String message) {
		super(type+" "+ message);
	}

	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
