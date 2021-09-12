package com.ecommerce.payment.service;

import com.ecommerce.payment.dto.RequestResponseDto;
import com.ecommerce.payment.model.PaymentModel;
import com.ecommerce.payment.repo.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PaymentService {

    List<PaymentModel> getListOfPaymentForProductId(long productId);
    PaymentModel doTransPayment(RequestResponseDto requestResponseDto);

    List<PaymentModel>  getListOfPayments();
}
