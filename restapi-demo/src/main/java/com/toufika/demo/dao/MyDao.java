package com.toufika.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.toufika.demo.repo.MyRepository;
import com.toufika.demo.request.Product;



@Component
public class MyDao {
	
	@Autowired
	MyRepository repo;
	
	public Product add(Product product) {
		Product save = repo.save(product);
		return save;
	}
	
	public Product getProduct(int id) {
		 Product p= repo.findById(id).orElse(null);
		return p;
	}
	
	public Product update(int id,Product product) {
		Product p= repo.findById(id).orElse(null);
		if(p !=null) {
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			return repo.save(p);
		}
		else {
			return null;
		}
		
	}
	public Product delete(int id) {
		Product product = repo.findById(id).orElse(null);
		if(product !=null) {
			repo.delete(product);
			return product;
		}else {
			return null;
		}
		
	}
	/*
	public void delete(int id) {
		repo.deleteById(id);
	}
	*/
	
	/*
	public void update(Product product) {
		Product p = repo.findById(product.getId()).orElse(null);
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		
		repo.save(p);
		
	}
	*/
	
}
