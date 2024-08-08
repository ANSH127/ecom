package com.rest.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String email, String password);
	

}
