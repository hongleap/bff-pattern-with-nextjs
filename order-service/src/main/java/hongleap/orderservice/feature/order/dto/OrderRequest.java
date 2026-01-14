package hongleap.orderservice.feature.order.dto;

import java.math.BigDecimal;

public record OrderRequest(
        String productName,
        Integer quantity,
        BigDecimal totalPrice
) {

}
