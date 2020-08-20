package com.rosales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Order;

public interface IOrderRepo extends JpaRepository<Order, Integer>{

}
