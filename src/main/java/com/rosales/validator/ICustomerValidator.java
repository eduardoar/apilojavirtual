package com.rosales.validator;

import com.rosales.model.Customer;


public interface ICustomerValidator {
	
	void validator(String operation, Customer customer);	
	void validator(String operation, String value);

}
