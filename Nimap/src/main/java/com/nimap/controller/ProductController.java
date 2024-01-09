package com.nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Product;
import com.nimap.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//get all product
    @GetMapping("")
	public ResponseEntity<?> getAllProducts(@RequestParam (defaultValue = "1" ) int page,@RequestParam(defaultValue ="5" )int pagesize)
	{
		return productService.getAllProducts(page, pagesize);
	}
	
    //create new product data
    @PostMapping(" ")
	public ResponseEntity<?> addProduct(@RequestBody @Valid Product product)
	{
		return productService.addProduct(product);
	}
	
    //get all product based on id
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	//update product based on id
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@RequestBody @Valid Product product,@PathVariable int id)
	{
		return productService.updateById(product, id);
		
	}
	
	//delete product based on id;
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id)
	{
		return productService.deleteById(id);
	}
	
	
	

}
