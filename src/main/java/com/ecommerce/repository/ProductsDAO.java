package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer>{

}
