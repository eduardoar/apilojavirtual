package com.rosales.validator.impl;

import org.springframework.stereotype.Service;
import com.rosales.exception.ProductUnprocessableException;
import com.rosales.model.Product;
import com.rosales.validator.IProductValidator;

@Service
public class ProductValidatorImpl implements IProductValidator {
	
	Product prod;
	
	@Override
	public void validator(String operation, Product product) {
		
		switch (operation) {
		case "create":			
						
			if(product.getName() == null || product.getName().isEmpty()) {
				throw new ProductUnprocessableException("The Product Name is mandatory");
			}
			if(product.getDescription() == null || product.getDescription().isEmpty()) {
				throw new ProductUnprocessableException("The Product Description is mandatory");
			}
			if(product.getPrecio() == null || product.getPrecio() == 0) {
				throw new ProductUnprocessableException("The Product Price is mandatory");
			}			
			break;			
		default:
			break;
		}			
	}	
	
}
