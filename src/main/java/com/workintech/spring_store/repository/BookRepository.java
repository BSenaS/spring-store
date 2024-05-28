package com.workintech.spring_store.repository;

import com.workintech.spring_store.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
