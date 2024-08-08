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

import com.rest.springboot.entities.Wishlist;
import com.rest.springboot.service.WishlistService;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RequestMapping("/api/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	// creating a post mapping that post the wishlist detail in the database
	@PostMapping("/create")
	public Wishlist saveWishlist(@RequestBody Wishlist wishlist) {

		return wishlistService.saveWishlist(wishlist);

	}

	// creating a get mapping that retrieves all the wishlist detail from the
	// database
	@GetMapping("/getwishlist")
	public List<Wishlist> getWishlist() {
		return wishlistService.fetchAllWishlist();
	}
	
	// creating a get mapping that retrieves the detail of a specific wishlist
	@GetMapping("/getwishlist/{userId}")
	public List<Wishlist> getWishlistByUserId(@PathVariable("userId") Integer userId){
		return wishlistService.fetchWishlistByUserId(userId);
	}
	
	// check if product is in wishlist or not by product id and user id
	@GetMapping("/checkwishlist/{userId}/{productId}")
	public boolean checkWishlist(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
		return wishlistService.checkWishlist(userId, productId);
	}
	
	// delete product from wishlist by product id and user id
	@DeleteMapping("/delete/{userId}/{productId}")
	public void deleteWishlist(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
		wishlistService.deleteWishlist(userId, productId);
	}
	
	

}
