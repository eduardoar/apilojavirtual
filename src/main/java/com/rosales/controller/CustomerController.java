package com.rosales.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rosales.model.Customer;
import com.rosales.service.ICustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@ApiOperation(value = "List all clients")
	@GetMapping
	public ResponseEntity<List<Customer>> list(){
		List<Customer> list = service.list();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search client by cpf")
	@GetMapping("/{cpf}")
	public ResponseEntity<Customer> findCustomerByCpf(@PathVariable("cpf") String cpf) {
		Customer cust = service.findCpf(cpf);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a  customer")
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Customer obj) {
		Customer cus = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cus.getIdCustomer()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Update customer")
	@PutMapping
	public ResponseEntity<Customer> update(@Valid @RequestBody Customer obj) {
		Customer cus = service.update(obj);
		return new ResponseEntity<Customer>(cus, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Remove customer")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
