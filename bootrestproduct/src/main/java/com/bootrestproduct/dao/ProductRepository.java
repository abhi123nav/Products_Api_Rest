package com.bootrestproduct.dao;

import org.springframework.data.repository.CrudRepository;


import com.bootrestproduct.entity.Products;

public interface ProductRepository extends CrudRepository <Products,Integer> {
	public Products findById(int id);

}
