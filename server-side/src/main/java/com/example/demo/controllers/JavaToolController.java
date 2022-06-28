package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.services.JavaToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JavaToolController {

    @Autowired
    private JavaToolService javaToolService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return javaToolService.getCategories();
    }

    @GetMapping(value = "/categories/{categoryId}")
    public Category getSingleCategory(@PathVariable Long categoryId){
        return  javaToolService.getSingleCategory(categoryId);
    }
}
