package com.example.lesson11.service;

import com.example.lesson11.dto.CategoryDto;
import com.example.lesson11.entity.Category;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
