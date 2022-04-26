package com.example.buymoreecommerce.services.impl;

import com.example.buymoreecommerce.dtos.LoginDto;
import com.example.buymoreecommerce.dtos.ProductDto;
import com.example.buymoreecommerce.models.Admin;
import com.example.buymoreecommerce.models.Products;
import com.example.buymoreecommerce.repositories.AdminRepository;
import com.example.buymoreecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void createProduct(ProductDto productDto) {
        Products product = new Products();
        product.setAmount(productDto.getAmount());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    //view products
    public Products getProductById(long id) {
        Optional<Products> products = productRepository.findById(id);
        return products.orElse(null);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String login(LoginDto loginDto) throws Exception {
        String response = "";
        Admin admin = adminRepository.findByEmail(loginDto.getEmail());
        if( admin == null) response += "User does not exist";
        else if(!admin.getPassword().equals(loginDto.getPassword())) response += "Incorrect Password";
        else response += "Success";
        return response;
    }
}
