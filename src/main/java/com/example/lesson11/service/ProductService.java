package com.example.lesson11.service;

import com.example.lesson11.dto.ProductDto;
import com.example.lesson11.entity.Attachment;
import com.example.lesson11.entity.Category;
import com.example.lesson11.entity.Measurement;
import com.example.lesson11.entity.Product;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.AttachmentRepository;
import com.example.lesson11.repository.CategoryRepository;
import com.example.lesson11.repository.MeasurementRepository;
import com.example.lesson11.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:43
 * Project : lesson11
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;


    public Result addProduct(ProductDto productDto){
        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if(exists)
            return new Result("Bunday mahsulot ushbu kategoriyada mavjud",false);

        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        if (categoryOptional.isEmpty()) {
            return new Result("Category not found",false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (optionalAttachment.isEmpty()) {
            return new Result("Photo not found",false);
        }

        Optional<Measurement> measurementOptional = measurementRepository.findById(productDto.getMeasurementId());
        if (measurementOptional.isEmpty()) {
            return new Result("Measurement not found",false);
        }

        Product product=new Product();
        product.setName(productDto.getName());
        product.setCode("1");// TODO: 22.03.2022 code must generate
        product.setCategory(categoryOptional.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(measurementOptional.get());
        productRepository.save(product);
        return new Result("Product saved",true);
    }
}
