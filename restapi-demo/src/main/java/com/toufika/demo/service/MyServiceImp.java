package com.toufika.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.toufika.demo.dao.MyDao;
import com.toufika.demo.request.Product;

@Component
public class MyServiceImp implements MyService {

	@Autowired
	MyDao dao;
	
	
	public Product add(Product product) {
		return dao.add(product);	
	}
	
	public Product getProduct(int id) {
		return dao.getProduct(id);
	}
	
	public Product  update(int id,Product product) {
		return dao.update(id,product);
	}
	
	public Product delete(int id) {
		return dao.delete(id);
	}
}
