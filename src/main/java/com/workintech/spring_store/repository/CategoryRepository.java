package com.workintech.spring_store.repository;

import com.workintech.spring_store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    //Bura da parametreden gelen veri :title (önüne iki nokta koyularak yazılır)
    @Query("SELECT c FROM Category c WHERE c.title = :title")
    Optional<Category> findByTitle(String title);
}
