package com.app.pojos;

import javax.persistence.*;

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
@Table(name="services")
public class Services extends BaseEntity {
	
	@Column(length=50)
	private String serviceName;
	
	private String description;
	
	private String estimatedTime;
	
	@Column(nullable = false)
	private double estimatedCost;
	

}
