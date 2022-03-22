package com.example.lesson11.service;

import com.example.lesson11.dto.CategoryDto;
import com.example.lesson11.entity.Category;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:06
 * Project : lesson11
 */
@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId()!=null) {
            Optional<Category> categoryParentOptional = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (categoryParentOptional.isEmpty()) {
                return new Result("Bunday ota category mavjud emas",false);
            }
            category.setParentCategory(categoryParentOptional.get());
        }
        categoryRepository.save(category);
        return new Result("Muvaffaqiyatli saqlandi",true);
    }

    public List<Category> getCategories() {
        List<Category> all = categoryRepository.findAll();
        return all;
    }

    public Result getCategory(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty())
            return new Result("Category not found",false);
        return new Result(categoryOptional.get(),true);
    }

    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty())
            return new Result("Category not found",false);
        Category category = categoryOptional.get();
        category.setName(categoryDto.getName());
        Optional<Category> parentCategoryOptional = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (parentCategoryOptional.isEmpty()) {
            return new Result("Parent category not found",false);
        }
        category.setParentCategory(parentCategoryOptional.get());
        categoryRepository.save(category);
        return new Result("Successfully updated",true);
    }

    public Result deleteCategory(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty())
            return new Result("Category not found",false);
        categoryRepository.delete(categoryOptional.get());
        return new Result("Successfully deleted",true);
    }
}
