package ru.novikova.spring_data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novikova.spring_data.entities.Category;
import ru.novikova.spring_data.repositories.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
