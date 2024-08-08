package com.rest.springboot.entities;

import java.net.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer id;
	@Column(name = "pname", nullable = false)
	private String name;
	@Column(name = "price", nullable = false)
	private Double price;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "description", nullable = false,length = 500)
	private String description;
	@Column(name = "image", nullable = false)
	private URL image;
	
	

}
