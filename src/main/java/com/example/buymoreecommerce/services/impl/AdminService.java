package com.example.buymoreecommerce.services.impl;

import com.example.buymoreecommerce.dtos.LoginDto;
import com.example.buymoreecommerce.dtos.ProductDto;
import com.example.buymoreecommerce.dtos.SignUpDto;
import com.example.buymoreecommerce.models.Products;

import java.util.List;

public interface AdminService {
    void createProduct(ProductDto productDto);
    void deleteProduct(long id);
    Products getProductById(long id);
    String login (LoginDto loginDto) throws Exception;
    List<Products> getAllProducts();

}
