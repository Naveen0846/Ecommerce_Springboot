package com.ecommerce.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerDAO;
import com.ecommerce.requestVo.CustomerVo;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public boolean saveCustomerVo(CustomerVo customerVo) {
		LOGGER.info("Start of saveCustomerVo", customerVo.getEmail());
		boolean customerSaved = false;
		Customer customerDetails = CustomerDTO.mapToCustomer(customerVo);
		LOGGER.info("Customer details mapped success");
		customerDAO.save(customerDetails);
		customerSaved = true;
		LOGGER.info("end of createAdmin");
		return customerSaved;
	}

	@Override
	public List<Customer> getAllCustomers() {
		LOGGER.info("Get Customer List");
		List<Customer> allCust;
		allCust = customerDAO.findAll();
		if (allCust.size() > 0) {
			LOGGER.info("Customer List Exists");
			return allCust;
		}
		LOGGER.info("Customer List not found");
		return null;
	}

	@Override
	public Customer getCustomer(Integer cusId) {
		Customer customer;
		LOGGER.info("Get Customer Details");
		customer = customerDAO.findById(cusId).get();
		if (customer != null) {
			LOGGER.info("Customer Details Found");
			return customer;
		}
		LOGGER.info("Customer Details not found");
		return null;
	}

	@Override
	public Customer updateCustomer(CustomerVo customerVo) {
		return null;
	}

	@Override
	public boolean deleteCustomer(Integer cusId) {
		boolean customerDeleted = false;
		LOGGER.info("Get Customer Details");
		Customer customer = customerDAO.findById(cusId).get();
		if (customer != null) {
			LOGGER.info("Customer Details Found");
			customerDAO.deleteById(cusId);
			return customerDeleted = true;
		}
		LOGGER.info("Customer Details not found");
		return customerDeleted;
	}

}
