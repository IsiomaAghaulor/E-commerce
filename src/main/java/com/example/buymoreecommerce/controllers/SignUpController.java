package com.example.buymoreecommerce.controllers;

import com.example.buymoreecommerce.dtos.SignUpDto;
import com.example.buymoreecommerce.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private final CustomerService customerService;

    @Autowired
    public SignUpController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) throws Exception {
        SignUpDto signUpDto1 = new SignUpDto();
        model.addAttribute("signUpDto1", signUpDto1);
        return "signUp";
    }

    @PostMapping("/process-sign-up")
    public String processSignUp(@ModelAttribute("signUpDto") SignUpDto signUpDto) throws Exception {
    customerService.createUser(signUpDto);
        return "redirect:/";
    }
}
