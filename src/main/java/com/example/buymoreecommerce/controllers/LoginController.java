package com.example.buymoreecommerce.controllers;

import com.example.buymoreecommerce.dtos.LoginDto;
import com.example.buymoreecommerce.services.CustomerService;
import com.example.buymoreecommerce.services.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final CustomerService customerService;
    private final AdminService adminService;

    public LoginController(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String login (Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    @GetMapping("/customer-login")
    public String customerLogin(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "customer-login";
    }

    @PostMapping("/login")
    public String signIn (@ModelAttribute("loginDto") LoginDto loginDto, RedirectAttributes attributes, Model model) throws Exception {
        String response = adminService.login(loginDto);
        String response2 = customerService.login(loginDto);
        if(response.equals("Success")) {
            model.addAttribute("listOfProducts", adminService.getAllProducts());
            return "AdminHomePage";
        } else if (response2.equals("Success")) {
            model.addAttribute("listOfProducts", adminService.getAllProducts());
            return "Home";
        }
        else if(response.equals("Incorrect Password")) {
            attributes.addFlashAttribute("Invalid Password", "The password you entered is incorrect");
            return "redirect:/";
        }
        else {
            attributes.addFlashAttribute("User does not exist", "User does not exist, please sign up");
            return "redirect:/sign-up";
        }
    }


}
