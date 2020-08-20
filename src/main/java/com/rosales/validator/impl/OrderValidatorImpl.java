package com.rosales.validator.impl;

import org.springframework.stereotype.Service;
import com.rosales.exception.OrderUnprocessableException;
import com.rosales.model.Order;
import com.rosales.validator.IOrderValidator;

@Service
public class OrderValidatorImpl implements IOrderValidator {
	
	Order order;
	
	@Override
	public void validator(String operation, Order order) {
		
		switch (operation) {
		case "create":			
						
			if(order.getCustomer() == null || order.getCustomer().getIdCustomer() < 1) {
				throw new OrderUnprocessableException("The Cliente Information is mandatory");
			}
			if(order.getDate() == null) {
				throw new OrderUnprocessableException("The Order Date is mandatory");
			}
			if(order.getStatus() == null) {
				throw new OrderUnprocessableException("The Order Status is mandatory");
			}		
			if(order.getOrderDetail() == null) {
				throw new OrderUnprocessableException("The Order Detail is mandatory");
			}				
			break;			
		default:
			break;
		}			
	}	
	
}
