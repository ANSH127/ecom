package com.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entities.Cart;
import com.rest.springboot.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	// creating a post mapping that post the cart detail in the database
	@PostMapping("/create")
	public Cart saveCart(@RequestBody Cart cart) {

		return cartService.saveCart(cart);

	}

	// creating a delete mapping that deletes a specific cart
	@DeleteMapping("/delete/{cartId}")
	public void deleteCart(@PathVariable("cartId") Integer cartId) {
		cartService.deleteCart(cartId);
	}

	// creating a get mapping that retrieves the detail of a specific cart by user
	// id

	@GetMapping("/getcart/{userId}")
	public List<Cart> getCartByUserId(@PathVariable("userId") Integer userId) {

		List<Cart> cart = cartService.fetchCartByUserId(userId);
		// delete user object from cart object
//		for (Cart c : cart) {
//			c.setUser(null);
//		}
		return cart;
	}

	// check if product is in cart or not by product id and user id
	@GetMapping("/checkcart/{userId}/{productId}")
	public boolean checkCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
		return cartService.checkCart(userId, productId);
	}

	// update the quantity of the product in the cart
	@PostMapping("/updateqty/{id}/{count}")
	public void updateCart(@PathVariable("id") Integer cartId, @PathVariable("count") Integer count) {
		cartService.updateCart(cartId, count);
	}

}
