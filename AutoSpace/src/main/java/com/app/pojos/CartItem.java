package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="cart_items")
@ToString
public class CartItem extends BaseEntity {
	
	private int quantity;
	
	private double ServicePrice;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonBackReference
	private Cart myCart;
	
	@OneToOne
	@JoinColumn(name="service_id")
	private Services service;
	
	
	
	

}
