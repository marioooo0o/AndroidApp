package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaToolService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return  categoryRepository.findAll();
    }

    public Category getSingleCategory(Long categoryId){
        return  categoryRepository.findById(categoryId).orElseThrow();
    }
}
