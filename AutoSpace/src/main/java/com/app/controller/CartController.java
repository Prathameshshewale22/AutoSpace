package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cart;
import com.app.services.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartServiceImpl cart;
	
	@GetMapping("/addtocart")
	public Cart addToCart(@RequestParam Long customerId,@RequestParam Long serviceId) {
		return cart.addToCart(customerId, serviceId);
	}
	
	@GetMapping("/{customerId}")
	public Cart getCartDetailsByCustomerId(@PathVariable Long customerId) {
		return cart.getCartByCustomerId(customerId);
	}
	
	@GetMapping("/emptyCart")
	public void emptyCart(Long customerId) {
		 cart.clearCart(customerId);
	}
	
	@DeleteMapping("/{cartItemId}")
	public boolean removeCartItem(Long cartItemId) {
		return cart.removeCartItem(cartItemId);
	}
}
