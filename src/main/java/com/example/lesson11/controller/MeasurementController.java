package com.example.lesson11.controller;

import com.example.lesson11.entity.Measurement;
import com.example.lesson11.payload.Result;
import com.example.lesson11.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //get list, get one , edit, delete;
}
