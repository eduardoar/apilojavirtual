package com.rosales.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {
	
	@ExceptionHandler(CustomerExistException.class)
	public final ResponseEntity<ExceptionResponse> customerExist(CustomerExistException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.OK);
	}
	
	@ExceptionHandler(CustomerUnprocessableException.class)
	public final ResponseEntity<ExceptionResponse> customerUnprocessable(CustomerUnprocessableException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerNotExistException.class)
	public final ResponseEntity<ExceptionResponse> customerNumberExceeded(CustomerNotExistException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductUnprocessableException.class)
	public final ResponseEntity<ExceptionResponse> productUnprocessable(ProductUnprocessableException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderUnprocessableException.class)
	public final ResponseEntity<ExceptionResponse> orderUnprocessable(OrderUnprocessableException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
	}

}
