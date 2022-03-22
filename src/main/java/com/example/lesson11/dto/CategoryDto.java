package com.example.lesson11.dto;

import lombok.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:13
 * Project : lesson11
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String name;
    private Integer parentCategoryId;
}
