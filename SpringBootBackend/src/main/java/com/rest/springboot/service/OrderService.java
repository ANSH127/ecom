package com.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.OrderDAO;
import com.rest.springboot.entities.Order;


@Service
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;

	// save order
	public Order saveOrder(Order order) {
		return orderDAO.save(order);
	}

	// fetch order by user id and sort by order date in descending order
	public List<Order> fetchOrderByUserId(Integer userId) {
		return orderDAO.findByUserIdOrderByOrderDateDesc(userId);
	}

}
