package com.ecommerce.requestVo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductVo {

	private Integer prdId;

	private String prName;

	private String prPrice;

	private boolean availablity;

	private LocalDate createdOn;
}
