package com.exam.examserver.service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.Category;
import com.exam.examserver.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catrepo;

	public Category addCategory(Category category) {
		return catrepo.save(category);
	}
	public Category updateCategory(Category category) {
		return catrepo.save(category);
	}
	
	public Set<Category> getCategories(){
		return new LinkedHashSet<>(catrepo.findAll());
	}
	
	public Optional<Category> getCategory(Long cid) {
		return catrepo.findById(cid);
	}
	
	public void deleteCategory(Long cid) {
		catrepo.deleteById(cid);
		System.out.println("Deleted");
	}
}

