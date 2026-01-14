package hongleap.orderservice.feature.order;

import hongleap.orderservice.domain.Order;
import hongleap.orderservice.feature.order.dto.OrderResponse;
import hongleap.orderservice.feature.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse create(OrderRequest request) {
        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setProductName(request.productName());
        order.setQuantity(request.quantity());
        order.setTotalPrice(request.totalPrice());

        Order saved = orderRepository.save(order);

        return mapToResponse(saved);
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public OrderResponse findByUuid(String uuid) {
        Order order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return mapToResponse(order);
    }

    @Override
    public OrderResponse update(String uuid, OrderRequest request) {
        Order order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if(request.productName()!=null){
            order.setProductName(request.productName());
        }
        if(request.quantity()!=null){
            order.setQuantity(request.quantity());
        }
        if(request.totalPrice()!=null){
            order.setTotalPrice(request.totalPrice());
        }

        Order updated = orderRepository.save(order);

        return mapToResponse(updated);
    }

    @Override
    public void delete(String uuid) {
        Order order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }

    private OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getUuid(),
                order.getProductName(),
                order.getQuantity(),
                order.getTotalPrice(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }
}
