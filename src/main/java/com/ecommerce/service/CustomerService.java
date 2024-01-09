package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Customer;
import com.ecommerce.requestVo.CustomerVo;

public interface CustomerService {

	public boolean saveCustomerVo(CustomerVo customerVo);

	public List<Customer> getAllCustomers();

	public Customer getCustomer(Integer cusId);

	public Customer updateCustomer(CustomerVo customerVo);

	public boolean deleteCustomer(Integer cusId);
}
