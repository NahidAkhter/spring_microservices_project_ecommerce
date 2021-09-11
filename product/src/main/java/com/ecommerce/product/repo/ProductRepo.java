package com.ecommerce.product.repo;

import com.ecommerce.product.model.ProductPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<ProductPO, Long> {
}
