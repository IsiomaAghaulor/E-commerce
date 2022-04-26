package com.example.buymoreecommerce.controllers;

import com.example.buymoreecommerce.dtos.ProductDto;
import com.example.buymoreecommerce.repositories.CustomerRepository;
import com.example.buymoreecommerce.services.impl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService ;

    @Autowired
    public AdminController(AdminService adminService) {
      this.adminService = adminService;
    }

    @GetMapping("/createProduct")
    public String index(Model model) {

        ProductDto productDto = new ProductDto();
        model.addAttribute("product", productDto);
        return "AddNewProduct";

    }

    @PostMapping("/add-new-product")
    public String addNewProduct(@ModelAttribute("product") ProductDto productDto, Model model){
        adminService.createProduct(productDto);
        model.addAttribute("listOfProducts", adminService.getAllProducts());
        return "AdminHomePage";
    }

}
