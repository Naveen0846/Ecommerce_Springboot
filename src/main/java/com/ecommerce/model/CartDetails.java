package com.ecommerce.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_details")
public class CartDetails {

	private Integer cusId;

	private String prName;

	private Long prPrice;

	private Long quantity;

	private LocalDate createdOn;

}
