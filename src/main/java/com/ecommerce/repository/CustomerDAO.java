package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
