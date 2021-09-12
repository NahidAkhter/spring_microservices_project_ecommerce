package com.ecommerce.payment.service;

import com.ecommerce.payment.dto.RequestResponseDto;
import com.ecommerce.payment.model.PaymentModel;
import com.ecommerce.payment.repo.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements  PaymentService{

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentModel> getListOfPaymentForProductId(long productId) {
        return paymentRepository.findByProductId(productId);
    }

    @Override
    public PaymentModel doTransPayment(RequestResponseDto requestResponseDto) {
        PaymentModel paymentModel = new PaymentModel();
        BeanUtils.copyProperties(requestResponseDto, paymentModel);

        return paymentRepository.save(paymentModel);
    }

    @Override
    public List<PaymentModel> getListOfPayments() {

        List<PaymentModel> list = (List<PaymentModel>) paymentRepository.findAll();
        return list;
    }
}
