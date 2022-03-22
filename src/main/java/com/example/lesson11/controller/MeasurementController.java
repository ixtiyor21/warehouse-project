package com.example.lesson11.controller;

import com.example.lesson11.entity.Measurement;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 14:11
 * Project : lesson11
 */
@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement){
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }


    @GetMapping
    public List<Measurement> getMeasurements(){
        return measurementService.getMeasurements();
    }

    @GetMapping("/{id}")
    public Result getMeasurement(@PathVariable Integer id){
        return measurementService.getMeasurement(id);
    }

    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id,@RequestBody Measurement measurement){
        return measurementService.editMeasurement(id,measurement);
    }
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        return measurementService.deleteMeasurement(id);
    }


}
