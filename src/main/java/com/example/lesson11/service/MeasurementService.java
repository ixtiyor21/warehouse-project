package com.example.lesson11.service;

import com.example.lesson11.entity.Measurement;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 14:50
 * Project : lesson11
 */
@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if(existsByName){
            return new Result("Bunday o'lchov birligi mavjud",false);
        }
        measurementRepository.save(measurement);
        return new Result("Muvaffaqiyatli saqlandi",true);
    }
}
