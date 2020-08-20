package com.rosales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Order;
import com.rosales.repository.IOrderRepo;
import com.rosales.service.IOrderService;
import com.rosales.validator.IOrderValidator;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderRepo repo;
	
	@Autowired
	private IOrderValidator orderValidator;
	
	@Override
	public Order create(Order o) {
		orderValidator.validator("create", o);
		o.getOrderDetail().forEach(ord -> {
			ord.setOrder(o);
		});
		return repo.save(o);
	}

	@Override
	public Order update(Order c) {
		return repo.save(c);
	}

	@Override
	public List<Order> list() {
		return repo.findAll();
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
