package com.rest.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

	
	public List<Address> findByUserId(Integer userId);
	

}
