package com.workintech.spring_store.service;

import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    //Bu objeyi hard olarak baglama, AutoWired ile dependency injection yap.İhtiyac anın da spring kullansın.
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse findByTitle(String title) {
        Optional<Category> categoryOptional = categoryRepository.findByTitle(title);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return new CategoryResponse(category.getTitle());
        }
        return null;
    }

    @Override
    public CategoryResponse save(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return new CategoryResponse(savedCategory.getTitle());
    }
}
