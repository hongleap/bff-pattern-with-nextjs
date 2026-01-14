package hongleap.productservice.feature.product.dto;

public record ProductResponse(
        String uuid,
        String name,
        Double price,
        String image,
        String description,
        String category
) {
}