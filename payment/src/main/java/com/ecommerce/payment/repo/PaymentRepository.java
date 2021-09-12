package com.ecommerce.payment.repo;


import com.ecommerce.payment.model.PaymentModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentModel, Long> {

    List<PaymentModel> findByProductId(long productId);
}
