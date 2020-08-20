package com.rosales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
