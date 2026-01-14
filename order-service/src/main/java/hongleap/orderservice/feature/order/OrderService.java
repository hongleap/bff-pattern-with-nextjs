package hongleap.orderservice.feature.order;


import hongleap.orderservice.feature.order.dto.OrderResponse;
import hongleap.orderservice.feature.order.dto.OrderRequest;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findByUuid(String uuid);

    OrderResponse update(String uuid, OrderRequest request);

    void delete(String uuid);
}
