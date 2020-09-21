package com.bootrestproduct.controller;

import java.util.List;
import java.util.Optional;

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

import com.bootrestproduct.entity.Products;
import com.bootrestproduct.service.ProductService;


@RestController
public class Productcontroller {
	
	@Autowired
	ProductService productService;
//all products	
@GetMapping("/products")	
public ResponseEntity<List<Products>> getProducts()
{
List<Products> products=(List<Products>)this.productService.getAllProducts();	
if(products.size()<=0)
{
return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}
System.out.println("hello");
return ResponseEntity.status(HttpStatus.CREATED).body(products);	
//	return ResponseEntity.of(Optional.of(products));

}


//single product
//@GetMapping("/products/{id}")
@GetMapping("/products/{id}")
public ResponseEntity<Products> getProducts(@PathVariable("id") int id)
{
	Products product=this.productService.getProductById(id);
	if(product==null)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(product));
}



@PostMapping("/products")
public ResponseEntity<Products> addproducts(@RequestBody Products product)
{Products p=null;
	try {
		p=this.productService.addProducts(product);
		return ResponseEntity.of(Optional.of(p));
	}
	catch(Exception e)
	{
	e.printStackTrace();	
	}
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

//delete
@DeleteMapping("/products/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id)
{
try {
	this.productService.deleteProduct(id);;
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
catch(Exception e)
{
e.printStackTrace();
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
}

//update
@PutMapping("/products/{id}")
public ResponseEntity<Products> updateProducts(@RequestBody Products product,@PathVariable("id") int id)
{
	try {
		
		this.productService.update(product, id);
		return ResponseEntity.ok().body(product);
		
	}
	catch(Exception e)
	{e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}


}
