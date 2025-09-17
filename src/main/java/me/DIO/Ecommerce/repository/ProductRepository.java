package me.DIO.Ecommerce.repository;

import me.DIO.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Busca produtos contendo parte do nome, ignorando case-sensitive
    List<Product> findByNameContainingIgnoreCase(String name);
}
