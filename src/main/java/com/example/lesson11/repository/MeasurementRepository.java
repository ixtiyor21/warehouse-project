package com.example.lesson11.repository;

import com.example.lesson11.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 14:56
 * Project : lesson11
 */
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);
}
