package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@Table(name="managers")
public class Manager extends BaseEntity {
	@Column(length = 20)
	private String firstName;

	@Column(length = 20)
	private String lastName;

	@Column(length = 40,unique=true,nullable = false)
	private String email;

	@Column(length = 20,unique = true,nullable = false)
//	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(length = 10,unique = true)
	private String mobileNumber;
	
//	@OneToOne
//	@JoinColumn(name = "center_id")
//	private ServiceCenter center;
//	public void addServiceCenter(ServiceCenter serviceCenter ) {
//		this.setCenter(serviceCenter);
//	}
	
}
