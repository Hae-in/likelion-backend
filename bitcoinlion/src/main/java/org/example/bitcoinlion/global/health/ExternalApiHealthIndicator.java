package org.example.bitcoinlion.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExternalApiHealthIndicator implements HealthIndicator {
    private final RestClient restClient = RestClient.create();

    @Override
    public Health health() {
        try {
            restClient.get()
                    .uri("https://www.google.com")
                    .retrieve()
                    .toBodilessEntity();
            return Health.up()
                    .withDetail("service", "google api ok")
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("service", "google api error")
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}
