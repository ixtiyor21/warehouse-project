package com.example.lesson11.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 14:06
 * Project : lesson11
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends Auditable{

    @Column(nullable = false,unique = true)
    private String phoneNumber;
}
