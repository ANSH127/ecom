package com.rest.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {

	 public List<Cart> findByUserId(Integer userId);
	 

}
