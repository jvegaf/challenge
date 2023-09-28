package me.jvegaf.challenge.application.price;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PriceResponse(Long id, Long productId, Long brandId, Instant startDate, Instant endDate,
    BigDecimal price, Integer priceList) {
}
