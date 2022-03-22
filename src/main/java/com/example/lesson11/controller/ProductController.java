package com.example.lesson11.controller;

import com.example.lesson11.dto.ProductDto;
import com.example.lesson11.entity.Product;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Result getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Result editProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        return productService.editProduct(id,productDto);
    }


}
