package com.example.buymoreecommerce.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double amount;
    private String description;


}