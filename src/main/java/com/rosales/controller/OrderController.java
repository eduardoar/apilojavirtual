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

import com.rosales.model.Order;
import com.rosales.service.IOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	private IOrderService service;
	
	@ApiOperation(value = "List orders")
	@GetMapping
	public ResponseEntity<List<Order>> list(){
		List<Order> list = service.list();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Generate order")
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Order obj) {
		Order cus = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cus.getIdOrder()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Update order")
	@PutMapping
	public ResponseEntity<Order> update(@Valid @RequestBody Order obj) {
		Order cus = service.update(obj);
		return new ResponseEntity<Order>(cus, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Remove order")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
