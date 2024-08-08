package com.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.CartDAO;
import com.rest.springboot.entities.Cart;

@Service
public class CartService {

	@Autowired
	private CartDAO cartDAO;

	public Cart saveCart(Cart cart) {
		return cartDAO.save(cart);
	}

	public void deleteCart(Integer cartId) {
		cartDAO.deleteById(cartId);
	}

	public List<Cart> fetchCartByUserId(Integer userId) {
		return cartDAO.findByUserId(userId);
	}

	public boolean checkCart(Integer userId, Integer productId) {
		List<Cart> cart = cartDAO.findByUserId(userId);
		for (Cart c : cart) {
			if (c.getProduct().getId() == productId) {
				return true;
			}
		}
		return false;

	}
	
	// update the quantity of the product in the cart
	public void updateCart(Integer cartId, Integer count) {
		Cart cart = cartDAO.findById(cartId).get();
		cart.setCount(count);
		cartDAO.save(cart);
	}

	public void deleteCartByUserId(Integer userId) {
		List<Cart> cart = cartDAO.findByUserId(userId);
		for (Cart c : cart) {
			cartDAO.delete(c);
		}
	}
	
	

}
