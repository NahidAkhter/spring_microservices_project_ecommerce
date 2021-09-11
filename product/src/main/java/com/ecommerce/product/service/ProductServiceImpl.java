package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.ProductPO;
import com.ecommerce.product.repo.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Optional<ProductPO> getProductById(long id) {
        Optional<ProductPO> productDto = productRepo.findById(id);
        return productDto;
    }

    @Override
    public ProductDto addNewProduct(ProductDto productDto) {

        ProductPO productPO = new ProductPO();

        BeanUtils.copyProperties(productDto, productPO);
        productRepo.save(productPO);
        BeanUtils.copyProperties(productPO, productDto);

        return productDto;
    }
}
