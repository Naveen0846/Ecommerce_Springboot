package com.ecommerce.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.CartDetails;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CartDAO;
import com.ecommerce.repository.CustomerDAO;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private CustomerDAO customerDAO;

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public CartDetails addToCart(CartDetails cartDetails) {
		LOGGER.info("Start of addToCart");
		return cartDAO.save(cartDetails);
	}

	@Override
	public CartDetails getCartDetails(Integer cusId) {
		LOGGER.info("check Customer exists ", cusId);
		Customer custDetails = customerDAO.findById(cusId).get();
		if (custDetails != null) {
			CartDetails crDetails = cartDAO.findById(cusId).get();
			if (crDetails != null) {
				return crDetails;
			} else {
				return null;
			}
		}
		return null;
	}

}
