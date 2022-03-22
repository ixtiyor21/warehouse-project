package com.example.lesson11.repository;

import com.example.lesson11.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:06
 * Project : lesson11
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
