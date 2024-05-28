package com.workintech.spring_store.service;

import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryService {
    CategoryResponse findByTitle(String title);
    CategoryResponse save(Category category);

}
