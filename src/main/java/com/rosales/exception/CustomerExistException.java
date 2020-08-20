package com.rosales.exception;

// Exception personalized status 200

public class CustomerExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String DESCRIPTION = "Customer Exist";
	
	public CustomerExistException(String error) {
		super(DESCRIPTION + ": " + error);
	}

}
