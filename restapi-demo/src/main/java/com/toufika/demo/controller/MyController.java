package com.toufika.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toufika.demo.request.Product;
import com.toufika.demo.response.ProductResponse;
import com.toufika.demo.service.MyService;

@RestController
public class MyController {

	
	@Autowired
	MyService service;
	         
	@Autowired
	private ProductResponse response;
	
	@PostMapping("/product")
	public ResponseEntity<ProductResponse> product(@RequestBody Product product){
		System.out.println(product);
		Product p=service.add(product);
		
		if(p!=null) {
			response.setError(false);
			response.setMsg("resquest data received and providing success response");
			response.setProducts(Arrays.asList(p));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
			
		}else {
			
			response.setError(true);
			response.setMsg("Failed to add");
			response.setProducts(null);    
			return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
		}
		
		
		//response.setError(false);
		//response.setMsg("resquest data received and providing success response")
		//response.setProducts(Arrays.asList(product));
		//return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") int id){
		Product product = service.getProduct(id);
		if(product!=null) {
			response.setError(false);
			response.setMsg("data fetched successfully");
			response.setProducts(Arrays.asList(product));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
		}
		else {
			
			response.setError(true);
			response.setMsg("failed to fetch");
			response.setProducts(null);
			return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
		}
		
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductResponse> update(@PathVariable("id") int id,@RequestBody Product product){
		Product update = service.update(id,product);
		if(update!=null) {
			response.setError(false);
			response.setMsg("data update successfully");
			response.setProducts(Arrays.asList(update));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
		}
		else {
			response.setError(true);
			response.setMsg("data update failed");
			response.setProducts(Arrays.asList(update));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProductResponse> delete(@PathVariable("id") int id){
		Product delete = service.delete(id);
		if(delete !=null) {
			response.setError(false);
			response.setMsg("data delete successfully");
			response.setProducts(Arrays.asList(delete));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
		}
		else {
			response.setError(true);
			response.setMsg("failed to delete");
			response.setProducts(Arrays.asList(delete));
			return new ResponseEntity<ProductResponse>(response,HttpStatus.NOT_FOUND);
		}
		
	}
	
	   
}
