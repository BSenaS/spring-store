package com.workintech.spring_store.controller;

import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse save(@RequestBody Category category){
        return categoryService.save(category);
    }

    //Path variable / ile arar , RequestParam parametre olarak alır.
    //Birden fazla parametre göndereceksek RequestParam daha mantıklıdır.
    @GetMapping("/byTitle/{title}")
    public CategoryResponse findByTitle(@PathVariable String title){
        return categoryService.findByTitle(title);
    }
}
