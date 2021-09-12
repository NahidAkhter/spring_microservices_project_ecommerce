package com.ecommerce.payment.dto;


import lombok.Data;

@Data
public class RequestResponseDto {

    private long id;

    private String transactionType;
    private Double amount;
    private String bicNumber;
    private long productId;

}
