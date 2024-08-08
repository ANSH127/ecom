package com.rest.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springboot.entities.Wishlist;

public interface WishlistDAO extends JpaRepository<Wishlist, Integer> {
	
	public List<Wishlist> findByUserId(int userId);

}
