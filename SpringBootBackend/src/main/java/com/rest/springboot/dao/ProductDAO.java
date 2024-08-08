package com.rest.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
