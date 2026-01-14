package hongleap.productservice.feature.product;

import hongleap.productservice.feature.product.dto.ProductRequest;
import hongleap.productservice.feature.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse findByUuid(String uuid);

    List<ProductResponse> findAll();

    ProductResponse update(String uuid, ProductRequest request);

    void delete(String uuid);
}
