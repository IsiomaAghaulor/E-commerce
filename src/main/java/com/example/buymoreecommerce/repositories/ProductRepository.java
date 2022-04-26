package com.example.buymoreecommerce.repositories;

import com.example.buymoreecommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
