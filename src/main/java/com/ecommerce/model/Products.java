package com.ecommerce.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products_details")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_ID")
	private Integer prdId;

	@Column(name = "product_name")
	private String prName;

	@Column(name = "product_price")
	private String prPrice;

	@Column(name = "product_availablity")
	private boolean availablity;

	@Column(name = "product_availablity")
	private LocalDate createdOn;

}
