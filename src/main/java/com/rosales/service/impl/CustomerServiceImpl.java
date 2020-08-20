package com.rosales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Customer;
import com.rosales.repository.ICustomerRepo;
import com.rosales.service.ICustomerService;
import com.rosales.validator.ICustomerValidator;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerRepo repo;
	
	@Autowired
	private ICustomerValidator customerValidator;
	
	@Override
	public Customer create(Customer c) {
		customerValidator.validator("create", c);
		return repo.save(c);
	}

	@Override
	public Customer update(Customer c) {
		return repo.save(c);
	}

	@Override
	public List<Customer> list() {
		return repo.findAll();
	}

	@Override
	public Customer findCpf(String cpf) {
		customerValidator.validator("find", cpf);
		return repo.findByCpf(cpf);		
	}

	@Override
	public boolean delete(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
