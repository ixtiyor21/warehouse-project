package com.example.lesson11.repository;

import com.example.lesson11.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:44
 * Project : lesson11
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    boolean existsByNameAndCategoryId(String name,Integer categoryId);

}
