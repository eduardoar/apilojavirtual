package com.rosales.validator;

import com.rosales.model.Order;

public interface IOrderValidator {
	
	void validator(String operation, Order order);

}
