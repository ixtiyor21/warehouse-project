package com.example.lesson11.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 13:12
 * Project : lesson11
 */

@Getter
@Setter
@ToString
@Entity
public class Measurement extends Auditable{

}
