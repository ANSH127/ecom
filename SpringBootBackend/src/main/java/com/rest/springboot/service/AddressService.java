package com.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.AddressDAO;
import com.rest.springboot.entities.Address;


@Service
public class AddressService {
	
	@Autowired
	private AddressDAO addressDAO;
	
	// save address
	public Address saveAddress(Address address) {
		return addressDAO.save(address);
	}
	
	// fetch address by user id
	public List<Address> fetchAddressByUserId(Integer userId) {
		return addressDAO.findByUserId(userId);
	}
	
	// fetch address by address id
	public Address fetchAddressById(Integer addressId) {
		return addressDAO.findById(addressId).get();
	}
	
	

}
