package com.workintech.spring_store.service;

import com.workintech.spring_store.dto.BookResponse;
import com.workintech.spring_store.entity.Book;

public interface BookService {
    BookResponse save(Book book);

    BookResponse saveByCateGory(long categoryId, Book book);
}
