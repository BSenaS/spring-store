package com.workintech.spring_store.controller;

import com.workintech.spring_store.dto.BookResponse;
import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Book;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.service.BookService;
import com.workintech.spring_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public BookController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    //long category_id , Book book gelecek
    @PostMapping("/{category_id}")
    public BookResponse save(@PathVariable long category_id,
                             @RequestBody Book book){
        Category category = categoryService.findById(category_id);
        book.setCategory(category);
        category.getBooks().add(book);

        return bookService.save(book);
    }

    
}
