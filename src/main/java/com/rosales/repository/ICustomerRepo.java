package com.rosales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
	
	Customer findByCpf(String cpf);

}
