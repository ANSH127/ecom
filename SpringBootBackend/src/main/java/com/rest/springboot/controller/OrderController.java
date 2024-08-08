package com.rest.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entities.Cart;
import com.rest.springboot.entities.Order;
import com.rest.springboot.service.CartService;
import com.rest.springboot.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;

	// create order
	// create a post mapping that post the order detail in the database
	// return the order detail
	@PostMapping("/createorder/{userId}")
	public boolean saveOrder(@PathVariable("userId") Integer userId) {

		List<Cart> carts = cartService.fetchCartByUserId(userId);
		Double totalAmount = 0.0;

		if (carts.isEmpty()) {
			return false;
		}

		for (Cart c : carts) {
			totalAmount += c.getProduct().getPrice() * c.getCount();
		}

		for (Cart c : carts) {
			Order order = new Order();
			order.setUser(c.getUser());
			order.setProduct(c.getProduct());
			order.setQuantity(c.getCount());
			order.setTotalPrice(totalAmount);
			order.setStatus("Order Placed");
			order.setOrderDate(LocalDateTime.now());
			orderService.saveOrder(order);

		}

		// delete cart by user id
		cartService.deleteCartByUserId(userId);

		return true;

	}

	// fetch order by user id
	@GetMapping("/getorder/{userId}")
	public List<Order> getOrderByUserId(@PathVariable("userId") Integer userId) {
		return orderService.fetchOrderByUserId(userId);
	}

}
