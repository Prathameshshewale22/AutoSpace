package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

public class Cart extends BaseEntity {
 
	private int totalItems;
	private double totalCartPrice;
    @CreationTimestamp	
	private LocalDate createdOn;
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	@JsonBackReference
	private Customer cartOwner;
	
	@OneToMany(mappedBy="myCart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems=new ArrayList<>();
	
//	public void addCustomer(Customer customer) {
//		customer.setCustomerCart(this);
//		this.setCartOwner(customer);
//	}
	
	public void addCartItems(CartItem items) {
		items.setMyCart(this);
		int qty=items.getQuantity();
		double price=items.getServicePrice();
		totalItems+=qty;
		totalCartPrice+=price;
		this.cartItems.add(items);
		
	}

	
	
}
