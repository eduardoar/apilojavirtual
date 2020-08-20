package com.rosales.exception;

// Exception personalized status 400
public class ProductUnprocessableException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ProductUnprocessableException(String error) {
		super(error);
	}
	
}
