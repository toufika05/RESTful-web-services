package com.toufika.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toufika.demo.request.Product;

public interface MyRepository extends JpaRepository<Product,Integer>{

}
