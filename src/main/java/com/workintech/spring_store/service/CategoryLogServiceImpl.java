package com.workintech.spring_store.service;

import com.workintech.spring_store.document.CategoryLog;
import com.workintech.spring_store.repository.CategoryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryLogServiceImpl implements CategoryLogService{

    private CategoryLogRepository categoryLogRepository;

    @Autowired
    public CategoryLogServiceImpl(CategoryLogRepository categoryLogRepository) {
        this.categoryLogRepository = categoryLogRepository;
    }

    @Override
    public CategoryLog save(CategoryLog categoryLog) {
        return categoryLogRepository.save(categoryLog);
    }
}
