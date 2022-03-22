package com.example.lesson11.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 13:26
 * Project : lesson11
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean active=true;

}
