package com.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.ProductDAO;
import com.rest.springboot.entities.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public Product saveProduct(Product product) {
		return productDAO.save(product);
	}

	public List<Product> fetchAllProducts() {
		return productDAO.findAll();
	}

	public Product fetchProductById(int id) {
		if (productDAO.findById(id).isPresent()) {
			return productDAO.findById(id).get();
		}
		return null;
	}

}
