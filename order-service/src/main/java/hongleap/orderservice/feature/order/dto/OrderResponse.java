package hongleap.orderservice.feature.order.dto;

import hongleap.orderservice.domain.Order.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        String uuid,
        String productName,
        Integer quantity,
        BigDecimal totalPrice,
        OrderStatus status,
        LocalDateTime createAt
) {
}
