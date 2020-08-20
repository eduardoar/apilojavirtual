package com.rosales.exception;

// Exception personalized status 400
public class OrderUnprocessableException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public OrderUnprocessableException(String error) {
		super(error);
	}
	
}
