package com.example.buymoreecommerce.services;

import com.example.buymoreecommerce.dtos.LoginDto;
import com.example.buymoreecommerce.dtos.SignUpDto;

public interface CustomerService {
    String login (LoginDto loginDto) throws Exception;

    void createUser(SignUpDto signUpDto);
}
