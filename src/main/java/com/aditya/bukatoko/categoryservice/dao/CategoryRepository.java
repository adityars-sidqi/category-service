package com.aditya.bukatoko.categoryservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.bukatoko.categoryservice.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
