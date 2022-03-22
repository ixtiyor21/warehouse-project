package com.example.lesson11.controller;

import com.example.lesson11.dto.CategoryDto;
import com.example.lesson11.entity.Category;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:03
 * Project : lesson11
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

}
