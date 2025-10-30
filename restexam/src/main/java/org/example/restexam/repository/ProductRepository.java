package org.example.restexam.repository;

import org.example.restexam.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ProductRepository  extends JpaRepository<Product,Long> {
}
