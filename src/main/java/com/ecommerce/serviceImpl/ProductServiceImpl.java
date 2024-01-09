package com.ecommerce.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.model.Products;
import com.ecommerce.repository.ProductsDAO;
import com.ecommerce.requestVo.ProductVo;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsDAO productsDAO;

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public boolean saveProducts(ProductVo productVo) {
		LOGGER.info("Start of saveProducts");
		boolean productSaved = false;
		Products mapToProduct = CustomerDTO.mapToProduct(productVo);
		LOGGER.info("product details mapped success");
		productsDAO.save(mapToProduct);
		productSaved = true;
		LOGGER.info("end of saveProducts");
		return productSaved;
	}

	@Override
	public List<Products> findProducts() {
		LOGGER.info("Get Customer List");
		List<Products> allCust;
		allCust = productsDAO.findAll();
		if (allCust.size() > 0) {
			LOGGER.info("Customer List Exists");
			return allCust;
		}
		LOGGER.info("Customer List not found");
		return null;
	}

	@Override
	public Products getProduct(Integer prId) {
		Products products;
		LOGGER.info("Get Customer Details");
		products = productsDAO.findById(prId).get();
		if (products != null) {
			LOGGER.info("Customer Details Found");
			return products;
		}
		LOGGER.info("Customer Details not found");
		return null;
	}

	@Override
	public boolean updateProduct(Integer prId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Integer prId) {
		boolean productDeleted = false;
		LOGGER.info("Get Customer Details");
		Products products = productsDAO.findById(prId).get();
		if (products != null) {
			LOGGER.info("Customer Details Found");
			productsDAO.deleteById(prId);
			return productDeleted = true;
		}
		LOGGER.info("Customer Details not found");
		return productDeleted;
	}

}
