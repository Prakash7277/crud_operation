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

import com.nimap.model.Category;
import com.nimap.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	//get all category product
	@GetMapping(" ") 
	public ResponseEntity<?> getAllCategory( @RequestParam (defaultValue = "1") int page ,@RequestParam (defaultValue = "3") int pagesize)
	{
	  return categoryService.getAllCategory(page, pagesize);
	}
	
	//create new catProduct
	@PostMapping(" ") 
	public ResponseEntity<?> addNewCategory(@RequestBody @Valid Category category)
	{
		return categoryService.addNewCategory(category);
	}
	
	//get category Product based on id
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id)
	{
       return categoryService.getCategoryById(id);
	}
	
	//update category Product based on id
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@RequestBody @Valid Category category,@PathVariable int id)
	{
		return categoryService.updateCategory(category, id);
	}
	
	//delete category product based on id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id)
	{
		return categoryService.deleteById(id);
	}

}
