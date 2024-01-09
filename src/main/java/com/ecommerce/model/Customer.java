package com.ecommerce.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_details")
public class Customer {

	@Id
	@Column(name = "customer_ID")
	private Integer custId;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "email")
	private String email;

	@Column(name = "Active")
	private boolean isActive = Boolean.FALSE;

	@Column(name = "created_on")
	private LocalDate createdOn;

	@OneToMany(cascade = CascadeType.ALL)
	private CartDetails cartDetails;
}
