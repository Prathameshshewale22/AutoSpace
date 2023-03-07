package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.Services;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CustomerServiceImpl custService;

	@Autowired
	private ServicesServiceImpl service;
	
	@Autowired
	private CartItemServiceImpl cartItems;
	
	@Override
	public Cart addToCart(Long CustomerId, Long ServiceId) {
		Customer customer=custService.getCustomerById(CustomerId);
		Services serviceToAdd=service.getServiceById(ServiceId);
		CartItem cartItem = cartItems.addCartItem(serviceToAdd);
		customer.getCustomerCart().addCartItems(cartItem);
		customer.getCustomerCart().setCartOwner(customer);
		cartRepo.save(customer.getCustomerCart());
		return getCartByCustomerId(CustomerId);
	}
	
	public Cart getCartByCustomerId(Long customerId) {
		Cart cart=cartRepo.findCartByCartOwnerId(customerId);
         cart.getCartItems().size();
		return cart;
		}

	@Override
	public void clearCart(Long custId) {
		Customer cust=custService.getCustomerById(custId);
		Cart CustomerCart=cust.getCustomerCart();
//		if(cartRepo.existsById(CustomerCart.getId()))
//		cartRepo.deleteById(CustomerCart.getId());	
//		System.out.println(CustomerCart.getId());
		CustomerCart.getCartItems().clear();
	}

	@Override
	public boolean removeCartItem(Long cartItemId) {
		return cartItems.removeCartItem(cartItemId);
		
	}

	@Override
	public Cart getCartById(Long cartId) {
		
		return cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("resource not found!!"));
	}
	
	

	
}
