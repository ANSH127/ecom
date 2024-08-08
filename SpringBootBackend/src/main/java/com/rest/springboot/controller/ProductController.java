package com.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entities.Product;
import com.rest.springboot.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// creating a post mapping that post the product detail in the database
	@PostMapping("/create")
	public Product saveProduct(@RequestBody Product product) {

		return productService.saveProduct(product);

	}

	// creating a get mapping that retrieves all the product detail from the
	// database
	@GetMapping("/getproduct")
	public List<Product> getProduct() {
		return productService.fetchAllProducts();
	}
	
	// creating a get mapping that retrieves the detail of a specific product
	@GetMapping("/getproduct/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		return productService.fetchProductById(id);
	}

}
