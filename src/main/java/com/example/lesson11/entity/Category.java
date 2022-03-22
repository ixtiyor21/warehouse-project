package com.example.lesson11.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 13:14
 * Project : lesson11
 */

@Getter
@Setter
@Entity
public class Category extends Auditable{

    @ManyToOne
    private Category parentCategory;

}
