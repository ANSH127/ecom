package com.rest.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rest.springboot.dao.UserDAO;
import com.rest.springboot.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public User saveUser(User user) {

		return userDAO.save(user);
	}

	public User fetchUserById(int userId) {
		return userDAO.findById(userId).get();
	}

	public void deleteUser(int userId) {
		userDAO.deleteById(userId);
	}

	public User authenticateUser(String email, String password) {
		return userDAO.findByEmailAndPassword(email, password);
	}

}
