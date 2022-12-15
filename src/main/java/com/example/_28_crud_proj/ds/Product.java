package com.example._28_crud_proj.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int quantity;
    private double price;
    private LocalDate lastUpdate;

    @ManyToOne
    private Category category;
}
