package me.jvegaf.challenge.domain.price;

import java.time.Instant;
import java.util.Optional;

public interface PriceRepository {
  Optional<Price> findPriceByCriteria(Instant date, Long productId, Long brandId);
}
