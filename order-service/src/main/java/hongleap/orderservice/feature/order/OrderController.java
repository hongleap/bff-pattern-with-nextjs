package hongleap.orderservice.feature.order;

import hongleap.orderservice.feature.order.dto.OrderRequest;
import hongleap.orderservice.feature.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request) {
        return orderService.create(request);
    }

    @GetMapping
    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{uuid}")
    public OrderResponse findByUuid(@PathVariable String uuid) {
        return orderService.findByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    public OrderResponse update(
            @PathVariable String uuid,
            @RequestBody OrderRequest request
    ) {
        return orderService.update(uuid, request);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        orderService.delete(uuid);
    }
}
