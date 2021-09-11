package com.ecommerce.product.controller;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.ProductPO;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id){

        ProductDto productDto = new ProductDto();
        Optional<ProductPO> product = productService.getProductById(Long.parseLong(id));
        BeanUtils.copyProperties(product,productDto);

        return ResponseEntity.ok().body(productDto);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto request){

        ProductDto productDto = productService.addNewProduct(request);
        productDto.setType("saved");

        return ResponseEntity.ok().body(productDto);
    }

}
