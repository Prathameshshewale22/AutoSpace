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
@ToString
public class Cart extends BaseEntity {
 
	private int totalItems;
	private double totalCartPrice;
    @CreationTimestamp	
	private LocalDate createdOn;
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer cartOwner;
	
	@OneToMany(mappedBy="myCart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems=new ArrayList<>();
	

	
	
}
