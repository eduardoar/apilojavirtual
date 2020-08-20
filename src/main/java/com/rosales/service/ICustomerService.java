package com.rosales.service;

import com.rosales.model.Customer;

public interface ICustomerService extends ICrud<Customer, Integer>{

	Customer findCpf(String cpf);
}
