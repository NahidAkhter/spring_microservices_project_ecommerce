package com.ecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TABLE")
public class ProductPO {

    @Id
    @GeneratedValue(strategy=AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    private long quantity;
    private double price;
    private String type;
    private String color;
    private String size;

}
