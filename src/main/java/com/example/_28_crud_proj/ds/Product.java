package com.example._28_crud_proj.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdated;

    @ManyToOne
    private Category category;
}
