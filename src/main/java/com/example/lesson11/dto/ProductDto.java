package com.example.lesson11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:41
 * Project : lesson11
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer MeasurementId;
}
