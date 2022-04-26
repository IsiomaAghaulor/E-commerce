package com.example.buymoreecommerce.services.impl;

import com.example.buymoreecommerce.dtos.LoginDto;
import com.example.buymoreecommerce.dtos.SignUpDto;
import com.example.buymoreecommerce.enums.Role;
import com.example.buymoreecommerce.models.Customer;
import com.example.buymoreecommerce.repositories.CustomerRepository;
import com.example.buymoreecommerce.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String login(LoginDto loginDto) throws Exception {
        String response = "";
        Customer customer = customerRepository.findByEmail(loginDto.getEmail());
        if(customer == null) response += "User does not exist";
        else if(!customer.getPassword().equals(loginDto.getPassword())) response += "Incorrect Password";
        else response += "Success";
        return response;
    }

    @Override
    public void createUser(SignUpDto signUpDto) {
        Customer customer = new Customer();
        customer.setEmail(signUpDto.getEmail());
        customer.setFirstName(signUpDto.getFirstName());
        customer.setLastName(signUpDto.getLastName());
        customer.setPassword(signUpDto.getPassword());

        customerRepository.save(customer);
    }
}
