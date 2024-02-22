package com.toufika.demo.service;

import org.springframework.stereotype.Service;

import com.toufika.demo.request.Product;

@Service
public interface MyService {

	Product add(Product product);
	
	Product getProduct(int id);
	
	Product update(int id,Product product);
	
	Product delete(int id);
	
}
