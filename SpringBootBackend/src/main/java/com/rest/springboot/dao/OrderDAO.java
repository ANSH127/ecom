package com.rest.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

	List<Order> findByUserIdOrderByOrderDateDesc(Integer userId);
	

}
