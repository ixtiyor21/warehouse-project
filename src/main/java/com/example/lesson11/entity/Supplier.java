package com.example.lesson11.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 13:40
 * Project : lesson11
 */


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier extends Auditable{

    @Column(unique = true,nullable = false)
    private String phoneNumber;
}
