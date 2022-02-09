package ru.novikova.spring_data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.novikova.spring_data.dtos.ProductDto;
import ru.novikova.spring_data.entities.Category;
import ru.novikova.spring_data.entities.Product;
import ru.novikova.spring_data.services.CategoryService;
import ru.novikova.spring_data.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/products")
    public List<ProductDto> findAll() {
        return productService.findAll()
                .stream()
                .map(x -> new ProductDto(x))
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable(name = "id") Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryName());
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }

    @GetMapping("/products/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
    }



}
