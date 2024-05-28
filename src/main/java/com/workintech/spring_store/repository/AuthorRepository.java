package com.workintech.spring_store.repository;

import com.workintech.spring_store.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
