package com.example.lesson11.controller;

import com.example.lesson11.dto.CategoryDto;
import com.example.lesson11.entity.Category;
import com.example.lesson11.entity.Measurement;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Result getCategory(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        return categoryService.editCategory(id,categoryDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }



}
