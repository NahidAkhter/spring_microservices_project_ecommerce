package com.ecommerce.product.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private long quantity;
    private double price;
    private String type;
    private String color;
    private String size;


}
