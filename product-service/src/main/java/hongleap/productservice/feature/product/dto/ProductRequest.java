package hongleap.productservice.feature.product.dto;

import hongleap.productservice.enums.Category;

public record ProductRequest(
        String name,
        Double price,
        String image,
        String description,
        Category category
) {
}