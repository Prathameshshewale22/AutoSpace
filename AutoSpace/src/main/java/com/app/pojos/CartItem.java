package com.app.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="cart_items")
public class CartItem extends BaseEntity {
	
	private int quantity;
	
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart myCart;
	
	@OneToOne
	@JoinColumn(name="service_id")
	private Services service;
	
	
	
	

}
