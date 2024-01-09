package com.ecommerce.requestVo;

import java.time.LocalDate;

import com.ecommerce.model.CartDetails;

import lombok.Data;

@Data
public class CustomerVo {

	private Integer custId;

	private String fname;

	private String lname;

	private String displayName;

	private String email;

	private boolean isActive = Boolean.FALSE;

	private LocalDate createdOn;

	private CartDetails cartDetails;
}
