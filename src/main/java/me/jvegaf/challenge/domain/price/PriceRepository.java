package me.jvegaf.challenge.domain.price;

import java.time.Instant;
import java.util.List;

public interface PriceRepository {
  List<Price> findPriceByCriteria(Instant date, Long productId, Long brandId);
}
