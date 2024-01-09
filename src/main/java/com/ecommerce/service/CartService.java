package com.ecommerce.service;

import com.ecommerce.model.CartDetails;

public interface CartService {

	public CartDetails addToCart(CartDetails cartDetails);

	public CartDetails getCartDetails(Integer cusId);
}
