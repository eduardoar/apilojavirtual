package com.rosales.exception;

// Exception personalized status 400
public class CustomerUnprocessableException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CustomerUnprocessableException(String error) {
		super(error);
	}
	
}
