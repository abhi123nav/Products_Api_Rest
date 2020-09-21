package com.bootrestproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrestproduct.dao.ProductRepository;
import com.bootrestproduct.entity.Products;

@Service
public class ProductService  {
	
@Autowired
ProductRepository productRepository;

public List<Products> getAllProducts()
{
	List<Products> list=(List<Products>) this.productRepository.findAll();
	return list;
}


//get single product
public Products getProductById(int id)
{
	Products product=null;
	try {
		product=this.productRepository.findById(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return product;
}
//POST
public Products addProducts(Products p)
{
	Products result=productRepository.save(p);
	return result;
}


//Delete
public void deleteProduct(int id)
{
	this.productRepository.deleteById(id);
}
//update
public void update(Products product,int id)
{
	product.setId(id);
this.productRepository.save(product);	
}
}
