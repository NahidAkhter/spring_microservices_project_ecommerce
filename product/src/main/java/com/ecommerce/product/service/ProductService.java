package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.ProductPO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Optional<ProductPO> getProductById(long id);
    ProductDto addNewProduct(ProductDto productDto);
}
