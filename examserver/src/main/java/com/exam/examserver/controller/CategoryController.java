package com.exam.examserver.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.Category;
import com.exam.examserver.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService catserv;
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		 Category cat1=catserv.addCategory(category);
		 return ResponseEntity.ok(cat1);
	}
	
	
	@GetMapping("/getCategory/{cid}")
	public Optional<Category> getCategory(@PathVariable("cid") Long cid) {
		 
		 return catserv.getCategory(cid);
	}
	
	@GetMapping("/getCategories")
	public Set<Category> getCategories() {
		 
		 return catserv.getCategories();
	}
	
	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody Category category) {
		
		return catserv.updateCategory(category);
	}
	
	@DeleteMapping("/deleteCategory/{cid}")
	public void deleteCategory(@PathVariable("cid") Long cid) {
		
		 catserv.deleteCategory(cid);
	}
	
	
	
}
