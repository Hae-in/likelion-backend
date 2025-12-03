package org.example.bitcoinlion.global.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class BusinessHoursHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        LocalTime now = LocalTime.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(18, 0);

        if(now.isAfter(startTime) && now.isBefore(endTime)) {
            return Health.up().build();
        } else {
            return Health.down()
                    .withDetail("reason", "영업종료(09:00 ~ 18:00)")
                    .withDetail("currentTime", now.toString())
                    .build();
        }
    }
}
