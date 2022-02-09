package ru.novikova.spring_data.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.novikova.spring_data.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private String categoryName;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryName = product.getCategory().getTitle();
    }
}
