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

import com.rosales.model.Product;
import com.rosales.service.IProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@ApiOperation(value = "List all products")
	@GetMapping
	public ResponseEntity<List<Product>> list(){
		List<Product> list = service.list();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a product")
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Product obj) {
		Product cus = service.create(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cus.getIdProduct()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Update product")
	@PutMapping
	public ResponseEntity<Product> modificar(@Valid @RequestBody Product obj) {
		Product cus = service.update(obj);
		return new ResponseEntity<Product>(cus, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Remove product")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
