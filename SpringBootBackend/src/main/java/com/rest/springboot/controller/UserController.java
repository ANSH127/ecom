package com.rest.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entities.User;
import com.rest.springboot.service.UserService;


@CrossOrigin(origins = "http://localhost:5173",maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	// creating a post mapping that post the user detail in the database
	@PostMapping("/create")
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);

	}
	
	// creating a get mapping that retrieves all the user detail from the database 
	@GetMapping("/getuser/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.fetchUserById(id);
	}
	
	// login authentication
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		return userService.authenticateUser(user.getEmail(), user.getPassword());
	}
	

}
