package com.rosales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Product;
import com.rosales.repository.IProductRepo;
import com.rosales.service.IProductService;
import com.rosales.validator.IProductValidator;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepo repo;
	
	@Autowired
	private IProductValidator productValidator;
	
	@Override
	public Product create(Product p) {
		productValidator.validator("create", p);
		return repo.save(p);
	}

	@Override
	public Product update(Product p) {
		return repo.save(p);
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
