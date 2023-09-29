package me.jvegaf.challenge.application.price;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PriceRequest(
        @NotNull(message = "applicationDate is null") Instant applicationDate,
        @NotNull(message = "productId is null") Long productId,
        @NotNull(message = "brandId is null") Long brandId
) {
}
