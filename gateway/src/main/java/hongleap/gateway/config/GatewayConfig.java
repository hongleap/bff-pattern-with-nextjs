package hongleap.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route("order",r -> r.path("/api/v1/orders/**")
                        .uri("http://localhost:8081")

                )
                .route("product",r -> r.path("/api/v1/products/**")
                        .uri("http://localhost:8082")
                )
                 //config authserver
                .route("auth",r -> r.path("/oauth2/**")
                        .uri("http://localhost:9000")
                )
                .build();

    }
}
