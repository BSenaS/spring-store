package com.workintech.spring_store.repository;

import com.workintech.spring_store.document.CategoryLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryLogRepository extends MongoRepository<CategoryLog, String> {
}
