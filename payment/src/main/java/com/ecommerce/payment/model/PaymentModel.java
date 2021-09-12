package com.ecommerce.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "PAYMENT_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String transactionType;
    private Double amount;
    private String bicNumber;
    private long productId;

}
