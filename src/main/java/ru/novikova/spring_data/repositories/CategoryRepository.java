package ru.novikova.spring_data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.novikova.spring_data.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByTitle(String title);
}
