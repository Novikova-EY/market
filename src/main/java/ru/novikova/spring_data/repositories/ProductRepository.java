package ru.novikova.spring_data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.spring_data.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
