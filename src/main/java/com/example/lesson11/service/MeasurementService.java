package com.example.lesson11.service;

import com.example.lesson11.entity.Measurement;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Measurement> getMeasurements(){
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements;
    }

    public Result getMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if(optionalMeasurement.isEmpty())
            return new Result("Measurement not found",false);
        return new Result(optionalMeasurement.get(),true);
    }

    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if(optionalMeasurement.isEmpty())
            return new Result("Measurement not found",false);
        Measurement measurement1 = optionalMeasurement.get();
        measurement1.setName(measurement.getName());
        measurement1.setActive(measurement.getActive());
        measurementRepository.save(measurement1);
        return new Result("Successfully edited",true);
    }

    public Result deleteMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if ((optionalMeasurement.isEmpty()))
            return new Result("Measurement not found",false);
        measurementRepository.delete(optionalMeasurement.get());
        return new Result("Successfully deleted",true);
    }
}
