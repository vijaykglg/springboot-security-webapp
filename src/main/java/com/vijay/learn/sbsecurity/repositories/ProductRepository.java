package com.vijay.learn.sbsecurity.repositories;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.sbsecurity.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
