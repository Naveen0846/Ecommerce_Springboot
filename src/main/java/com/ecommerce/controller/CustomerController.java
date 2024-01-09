package com.ecommerce.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Customer;
import com.ecommerce.requestVo.CustomerVo;
import com.ecommerce.responseVo.ResponseBuilder;
import com.ecommerce.responseVo.ResponseMessage;
import com.ecommerce.responseVo.ResponseVO;
import com.ecommerce.service.CustomerService;
import com.ecommerce.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/ecom")
public class CustomerController extends ResponseBuilder {

	@Autowired
	private CustomerService customerService;

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@PostMapping
	public ResponseEntity<ResponseVO> saveCustomer(@RequestBody CustomerVo customerVo) {
		LOGGER.info("Start of saveCustomer API ", customerVo.getEmail());
		if (!customerService.saveCustomerVo(customerVo)) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_REGISTRATION_FAILED);
		}
		LOGGER.info("end of saveCustomer API ", customerVo.getEmail());
		return buildSuccessResponse(ResponseMessage.CUSTOMER_REGISTERED_SUCCESSFULLY);
	}

	@GetMapping(value = "/customers")
	public ResponseEntity<ResponseVO> getCustomers() {
		LOGGER.info("Start of getCustomersList API ");
		List<Customer> allCustomers = customerService.getAllCustomers();
		if (allCustomers.size() == 0) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_DETAILS_UNAVAILABLE);
		}
		LOGGER.info("end of getCustomers API ");
		return buildSuccessResponse(allCustomers, ResponseMessage.CUSTOMER_DETAILS_FETCHED);
	}

	@GetMapping(value = "/customer")
	public ResponseEntity<ResponseVO> getCustomerDetails(@RequestParam(value = "cusId") Integer cusId) {
		LOGGER.info("Start of getCustomer API ");
		Customer customer = customerService.getCustomer(cusId);
		if (customer != null) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_DETAILS_UNAVAILABLE);
		}
		LOGGER.info("end of getCustomer API ");
		return buildSuccessResponse(customer, ResponseMessage.CUSTOMER_DETAILS_FETCHED);
	}

	@GetMapping(value = "/deleteCust")
	public ResponseEntity<ResponseVO> deleteCustomerDetails(@RequestParam(value = "cusId") Integer cusId) {
		LOGGER.info("Start of deleteCustomer API ");
		boolean deleteCustomer = customerService.deleteCustomer(cusId);
		if (!deleteCustomer) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_DELETION_FAILED);
		}
		LOGGER.info("end of deleteCustomer API ");
		return buildSuccessResponse(deleteCustomer, ResponseMessage.CUSTOMER_DETAILS_DELETED);
	}
}
