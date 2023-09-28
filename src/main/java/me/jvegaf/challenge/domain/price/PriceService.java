package me.jvegaf.challenge.domain.price;

import me.jvegaf.challenge.application.price.PriceRequest;
import me.jvegaf.challenge.application.price.PriceResponse;

public interface PriceService {

  PriceResponse findPriceByCriteria(PriceRequest priceRequestDTO);
}
