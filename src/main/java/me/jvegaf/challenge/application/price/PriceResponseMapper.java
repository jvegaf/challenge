package me.jvegaf.challenge.application.price;

import me.jvegaf.challenge.domain.price.Price;

public final class PriceResponseMapper {

  public PriceResponse toResponse(Price price) {
    return new PriceResponse(price.getId(),
        price.getProductId(),
        price.getBrandId(),
        price.getStartDate(),
        price.getEndDate(),
        price.getPrice(),
        price.getPriceList());
  }
}
