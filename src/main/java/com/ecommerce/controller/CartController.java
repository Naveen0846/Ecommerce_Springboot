package com.ecommerce.controller;

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

import com.ecommerce.model.CartDetails;
import com.ecommerce.responseVo.ResponseBuilder;
import com.ecommerce.responseVo.ResponseMessage;
import com.ecommerce.responseVo.ResponseVO;
import com.ecommerce.service.CartService;
import com.ecommerce.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/cart")
public class CartController extends ResponseBuilder {

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CartService cartService;

	@PostMapping(value = "/add")
	public ResponseEntity<ResponseVO> addToCart(@RequestBody CartDetails cartDetails) {
		LOGGER.info("Start of addToCart API ");
		CartDetails addToCart = cartService.addToCart(cartDetails);
		if (addToCart == null) {
			return buildErrorResponse(ResponseMessage.FAILED_ADDINGTO_CART);
		}
		LOGGER.info("end of addToCart API ");
		return buildSuccessResponse(ResponseMessage.ADDED_TO_CART);
	}

	@GetMapping(value = "/cart")
	public ResponseEntity<ResponseVO> getCustomers(@RequestParam(value = "crId") Integer crId) {
		LOGGER.info("Start of getCustomersList API ");
		CartDetails cartDetails = cartService.getCartDetails(crId);
		if (cartDetails != null) {
			return buildErrorResponse(ResponseMessage.CART_DETAILS_UNAVAILABLE);
		}
		LOGGER.info("end of getCustomers API ");
		return buildSuccessResponse(cartDetails, ResponseMessage.CART_DETAILS_FETCHED);
	}

}
