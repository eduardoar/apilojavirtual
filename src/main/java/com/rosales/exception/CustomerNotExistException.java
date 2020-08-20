package com.rosales.exception;

// Exception personalized status 404

public class CustomerNotExistException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CustomerNotExistException(String erro) {
		super(erro);
	}
	
}
