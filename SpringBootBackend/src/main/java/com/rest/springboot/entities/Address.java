package com.rest.springboot.entities;

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
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private Integer id;

	@Column(name = "uid", nullable = false)
	private Integer userId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "pincode", nullable = false)
	private String pincode;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "Phone", nullable = false)
	private String phone;

}
