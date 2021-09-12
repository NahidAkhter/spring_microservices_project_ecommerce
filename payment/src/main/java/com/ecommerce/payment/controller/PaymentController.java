package com.ecommerce.payment.controller;

import com.ecommerce.payment.dto.RequestResponseDto;
import com.ecommerce.payment.model.PaymentModel;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentModel>> getTotalListOfPayments(){
        List<PaymentModel> listOfPayments = service.getListOfPayments();

        return ResponseEntity.ok().body(listOfPayments);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<RequestResponseDto>> getPaymentForProductId(@PathVariable long productId){

        RequestResponseDto reqAndRes = new RequestResponseDto();
        List<RequestResponseDto> responseDtos = new ArrayList<>();
        List<PaymentModel> listOfPaymentForProductId = service.getListOfPaymentForProductId(productId);

        for(PaymentModel model : listOfPaymentForProductId){
            BeanUtils.copyProperties(model, reqAndRes);
        }

        return ResponseEntity.ok().body(responseDtos);
    }

    @PostMapping("/doTrans")
    public ResponseEntity<Object> doPayment(@RequestBody RequestResponseDto requestResponseDto){

        RequestResponseDto response = new RequestResponseDto();
        PaymentModel paymentModel = service.doTransPayment(requestResponseDto);

        BeanUtils.copyProperties(paymentModel, response);

        return ResponseEntity.ok().body(response);

    }


}
