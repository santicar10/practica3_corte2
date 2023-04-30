package com.example.practica3_corte2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private long id;
    private String name;
    private String tipo;
    private Double price;
}
