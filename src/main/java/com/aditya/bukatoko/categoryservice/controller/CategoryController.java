package com.aditya.bukatoko.categoryservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.bukatoko.categoryservice.entity.Category;
import com.aditya.bukatoko.categoryservice.exception.NotFoundException;
import com.aditya.bukatoko.categoryservice.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category saveCategory(@RequestBody Category category) {
		log.info("INSERT CATEGORY");
		return categoryService.save(category);
	}

	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable Long id) {
		Optional<Category> category = categoryService.findById(id);
		if (!category.isPresent())
			throw new NotFoundException("Not found id-" + id);
		return category;
	}

	@GetMapping
	public Page<Category> getCategory(Pageable pageable) {
		return categoryService.findAll(pageable);
	}

}
