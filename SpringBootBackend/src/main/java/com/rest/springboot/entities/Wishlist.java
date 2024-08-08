package com.rest.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishlist")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Wishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="uid", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="pid", nullable=false)
	private Product product;
	

}

