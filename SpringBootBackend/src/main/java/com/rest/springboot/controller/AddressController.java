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

import com.rest.springboot.entities.Address;
import com.rest.springboot.service.AddressService;


@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	// create address
	// create a post mapping that post the address detail in the database
	@PostMapping("/createaddress")
	public Address saveAddress(@RequestBody Address address) {
		System.out.println(address.getAddress());
		return addressService.saveAddress(address);
	}
	
	// fetch address by user id
	@GetMapping("/fetchaddress/{userId}")
	public List<Address> fetchAddressByUserId(@PathVariable("userId") Integer userId) {
		return addressService.fetchAddressByUserId(userId);
	}
	

}
