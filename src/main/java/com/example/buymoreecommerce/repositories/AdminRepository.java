package com.example.buymoreecommerce.repositories;

import com.example.buymoreecommerce.models.Admin;
import com.example.buymoreecommerce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail (String email);

}
