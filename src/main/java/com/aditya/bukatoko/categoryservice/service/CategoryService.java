package com.aditya.bukatoko.categoryservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aditya.bukatoko.categoryservice.dao.CategoryRepository;
import com.aditya.bukatoko.categoryservice.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

}
