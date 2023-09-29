package me.jvegaf.challenge.infra.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.jvegaf.challenge.domain.price.Price;

public final class PriceEntityMapper {

  private final Logger logger = LoggerFactory.getLogger(PriceEntityMapper.class);

  public Price toDomain(PriceEntity priceEntity) {

    logger.info("start mapping priceEntityId {}", priceEntity.getId());

    return Price.newBuilder()
        .withPrice(priceEntity.getPrice())
        .withPriceList(priceEntity.getPriceList())
        .withCurrency(priceEntity.getCurrency())
        .withEndDate(priceEntity.getEndDate())
        .withPriority(priceEntity.getPriority())
        .withProductId(priceEntity.getProductId())
        .withStartDate(priceEntity.getStartDate())
        .withId(priceEntity.getId())
        .withBrandId(priceEntity.getBrandId())
        .build();
  }
}
