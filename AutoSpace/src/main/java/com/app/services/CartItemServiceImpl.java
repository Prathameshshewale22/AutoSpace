package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CartItem;
import com.app.pojos.Services;
import com.app.repository.CartItemRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{
 
	@Autowired
	private CartItemRepository cartitemRepo;
	
	
	@Override
	public CartItem addCartItem(Services newSerivce) {
		CartItem newCartItem=new CartItem();
		newCartItem.setService(newSerivce);
		newCartItem.setQuantity(1);
		newCartItem.setServicePrice(newSerivce.getEstimatedCost());
		cartitemRepo.save(newCartItem);
		return newCartItem;
	}


}
