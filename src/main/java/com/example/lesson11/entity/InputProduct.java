package com.example.lesson11.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 13:59
 * Project : lesson11
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double amount;

    private Double price;

    private Date expireDate;

    @ManyToOne
    private Input input;
}
