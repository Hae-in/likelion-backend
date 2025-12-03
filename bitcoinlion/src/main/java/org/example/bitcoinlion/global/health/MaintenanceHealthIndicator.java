package org.example.bitcoinlion.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MaintenanceHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // stop/txt 같은 파일이 존재하면 점검중 이라고 판단하겠다.
        File maintenanceFile = new File("stop.txt");

        if (maintenanceFile.exists()) {
            return Health.down()
                    .withDetail("stopped", "긴급 점검 중입니다")
                    .build();
        }

        return Health.up().build();
    }
}
