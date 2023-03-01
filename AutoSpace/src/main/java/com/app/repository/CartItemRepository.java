package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CartItem;
import com.app.pojos.Services;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	
}
