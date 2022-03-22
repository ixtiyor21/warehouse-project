package com.example.lesson11.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 14:07
 * Project : lesson11
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double amount;

    private Double price;

    @ManyToOne
    private Output output;
}
