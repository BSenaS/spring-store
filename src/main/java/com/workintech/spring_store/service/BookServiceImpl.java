package com.workintech.spring_store.service;

import com.workintech.spring_store.dto.BookResponse;
import com.workintech.spring_store.entity.Book;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    //Eğer 2 service'i birbiri ile konusturacaksan repoyu çekme, service'i çek.
    private CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }


    @Override
    public BookResponse save(Book book) {
        Book savedBook = bookRepository.save(book);
        return new BookResponse(savedBook.getId(),savedBook.getName(),
                savedBook.getCategory().getTitle());
    }

    //Logicin service'e alınmıs hali.
    @Override
    public BookResponse saveByCateGory(long categoryId, Book book) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.getBooks().add(book);

        Book savedBook = bookRepository.save(book);
        return new BookResponse(savedBook.getId(),
                savedBook.getName(),
                savedBook.getCategory().getTitle());
    }


}
