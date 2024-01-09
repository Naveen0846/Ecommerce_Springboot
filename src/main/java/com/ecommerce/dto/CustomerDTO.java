package com.ecommerce.dto;

import java.time.LocalDate;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Products;
import com.ecommerce.requestVo.CustomerVo;
import com.ecommerce.requestVo.ProductVo;

public class CustomerDTO {

	public static Customer mapToCustomer(CustomerVo customerVo) {
		Customer customer = new Customer();
		customer.setEmail(customerVo.getEmail());
		customer.setFname(customerVo.getFname());
		customer.setDisplayName(customerVo.getLname());
		customer.setLname(customerVo.getLname());
		customer.setDisplayName(customerVo.getDisplayName());
		customer.setActive(false);
		customer.setCreatedOn(LocalDate.now());
		customer.setCartDetails(null);
		return customer;
	}

	public static CustomerVo VoToCustomer(Customer customer) {
		CustomerVo customerVo = new CustomerVo();
		customerVo.setEmail(customer.getEmail());
		customerVo.setFname(customer.getFname());
		customerVo.setDisplayName(customer.getLname());
		customerVo.setLname(customer.getLname());
		customerVo.setDisplayName(customer.getDisplayName());
		customerVo.setActive(false);
		customerVo.setCreatedOn(LocalDate.now());
		customerVo.setCartDetails(null);
		return customerVo;
	}

	public static Products mapToProduct(ProductVo productVo) {
		Products products = new Products();
		products.setAvailablity(true);
		products.setPrName(productVo.getPrName());
		products.setPrPrice(productVo.getPrPrice());
		products.setCreatedOn(LocalDate.now());
		return products;
	}

}
