package com.example.lesson11.controller;

import com.example.lesson11.dto.ProductDto;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:40
 * Project : lesson11
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Result addproduct(ProductDto productDto) {
        Result result = productService.addProduct(productDto);
        return result;
    }
}
