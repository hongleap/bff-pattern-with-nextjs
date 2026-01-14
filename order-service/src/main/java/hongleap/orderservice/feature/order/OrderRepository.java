package hongleap.orderservice.feature.order;

import hongleap.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByUuid(String uuid);

    boolean existsByUuid(String uuid);
}
