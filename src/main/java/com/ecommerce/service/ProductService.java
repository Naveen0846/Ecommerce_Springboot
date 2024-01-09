package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Products;
import com.ecommerce.requestVo.ProductVo;

public interface ProductService {

	public boolean saveProducts(ProductVo vo);

	public List<Products> findProducts();

	public Products getProduct(Integer prId);

	public boolean updateProduct(Integer prId);

	public boolean deleteProduct(Integer prId);
}
