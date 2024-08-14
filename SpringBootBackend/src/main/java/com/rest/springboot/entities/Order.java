package com.rest.springboot.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "uid", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "pid", nullable = false)
	private Product product;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@CreationTimestamp
	@Column(name = "order_date", nullable = false, updatable = false)
	private LocalDateTime orderDate;

	@Column(name = "delivery_date", nullable = false)
	private LocalDateTime deliveryDate;

	@Column(name = "total_price", nullable = false)
	private Double totalPrice;

	@Column(name = "status", nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable = false)
	private Address address;
	
	
	@Column(name="group_id")
	private Integer groupId;
	
	

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
		this.deliveryDate = orderDate.plus(5, ChronoUnit.DAYS);
	}

}
