package com.rosales.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.exception.CustomerExistException;
import com.rosales.exception.CustomerNotExistException;
import com.rosales.exception.CustomerUnprocessableException;
import com.rosales.model.Customer;
import com.rosales.repository.ICustomerRepo;
import com.rosales.validator.ICustomerValidator;

@Service
public class CustomerValidatorImpl implements ICustomerValidator {

	@Autowired
	private ICustomerRepo repo;
	
	Customer cust;
	
	@Override
	public void validator(String operation, Customer customer) {
		
		switch (operation) {
		case "create":			
						
			if(customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
				throw new CustomerUnprocessableException("The First Name is mandatory");
			}
			if(customer.getLastName() == null || customer.getLastName().isEmpty()) {
				throw new CustomerUnprocessableException("The Last Name is mandatory");
			}
			if(customer.getCpf() == null || customer.getCpf().isEmpty()) {
				throw new CustomerUnprocessableException("The CPF is mandatory");
			}
			if(customer.getEmail() == null || customer.getEmail().isEmpty()) {
				throw new CustomerUnprocessableException("The Email is mandatory");
			}
			if(customer.getTelephone() == null || customer.getTelephone().isEmpty()) {
				throw new CustomerUnprocessableException("The Telephone is mandatory");
			}
			if(customer.getAddress() == null || customer.getAddress().isEmpty()) {
				throw new CustomerUnprocessableException("The Address is mandatory");
			}
			
			cust = repo.findByCpf(customer.getCpf());				
			if(cust != null) {
				throw new CustomerExistException(cust.getCpf());
			}
			
			break;			
		default:
			break;
		}		
	}

	@Override
	public void validator(String operation, String value) {
		
		switch (operation) {
		case "find":
			cust = repo.findByCpf(value);		
			if(cust == null) {
				throw new CustomerNotExistException("The CPF is not registered");			
			}	
			break;

		default:
			break;
		}		
		
	}	
	
}
