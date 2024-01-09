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

import com.ecommerce.model.Products;
import com.ecommerce.requestVo.ProductVo;
import com.ecommerce.responseVo.ResponseBuilder;
import com.ecommerce.responseVo.ResponseMessage;
import com.ecommerce.responseVo.ResponseVO;
import com.ecommerce.service.ProductService;
import com.ecommerce.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends ResponseBuilder {

	@Autowired
	private ProductService productService;

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@PostMapping
	public ResponseEntity<ResponseVO> saveProduct(@RequestBody ProductVo productVo) {
		LOGGER.info("Start of saveProduct API ");
		if (!productService.saveProducts(productVo)) {
			return buildErrorResponse(ResponseMessage.PRODUCT_CREATION_FAILED);
		}
		LOGGER.info("end of saveProduct API ");
		return buildSuccessResponse(ResponseMessage.PRODUCT_CREATED_SUCCESSFULLY);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<ResponseVO> getProductList() {
		LOGGER.info("Start of getProductList API ");
		List<Products> productList = productService.findProducts();
		if (productList.size() == 0) {
			return buildErrorResponse(ResponseMessage.PRODUCT_DETAILS_INVALID);
		}
		LOGGER.info("end of getProductList API ");
		return buildSuccessResponse(productList, ResponseMessage.PRODUCT_DETAILS_FETCHED);
	}

	@GetMapping(value = "/product")
	public ResponseEntity<ResponseVO> getProductDetails(@RequestParam(value = "prId") Integer prId) {
		LOGGER.info("Start of getCustomer API ");
		Products products = productService.getProduct(prId);
		if (products != null) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_DETAILS_UNAVAILABLE);
		}
		LOGGER.info("end of getCustomer API ");
		return buildSuccessResponse(products, ResponseMessage.CUSTOMER_DETAILS_FETCHED);
	}

	@GetMapping(value = "/deletepr")
	public ResponseEntity<ResponseVO> deleteProduct(@RequestParam(value = "prId") Integer prId) {
		LOGGER.info("Start of deleteCustomer API ");
		boolean deleteProduct = productService.deleteProduct(prId);
		if (!deleteProduct) {
			return buildErrorResponse(ResponseMessage.CUSTOMER_DELETION_FAILED);
		}
		LOGGER.info("end of deleteCustomer API ");
		return buildSuccessResponse(deleteProduct, ResponseMessage.CUSTOMER_DETAILS_DELETED);
	}
}
