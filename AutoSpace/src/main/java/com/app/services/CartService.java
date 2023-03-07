package com.app.services;

import com.app.pojos.Cart;

public interface CartService {

	Cart addToCart(Long CustomerId,Long ServiceID); 
	
	Cart getCartByCustomerId(Long Id);
	
	void clearCart(Long id);
	
	boolean removeCartItem(Long cartItemId);
	
	Cart getCartById(Long cartId);
}
