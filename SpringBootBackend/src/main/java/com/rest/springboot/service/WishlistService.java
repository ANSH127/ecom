package com.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.WishlistDAO;
import com.rest.springboot.entities.Wishlist;


@Service
public class WishlistService {
	
	@Autowired
	private WishlistDAO wishlistDAO;
	
	public Wishlist saveWishlist(Wishlist wishlist) {
		return wishlistDAO.save(wishlist);
	}
	
	public List<Wishlist> fetchAllWishlist() {
		return wishlistDAO.findAll();
	}
	
	// fetch wishlist by user id
	public List<Wishlist> fetchWishlistByUserId(int userId) {
		return wishlistDAO.findByUserId(userId);
	}

	public boolean checkWishlist(Integer userId, Integer productId) {
		List<Wishlist> wishlist = wishlistDAO.findByUserId(userId);
		for (Wishlist w : wishlist) {
			if (w.getProduct().getId()==productId) {
				return true;
			}
		}
		return false;
	}

	public void deleteWishlist(Integer userId, Integer productId) {
		List<Wishlist> wishlist = wishlistDAO.findByUserId(userId);
		for (Wishlist w : wishlist) {
			if (w.getProduct().getId() == productId) {
				wishlistDAO.delete(w);
			}
		}
		
	}
	
	
	

	
}
