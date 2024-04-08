package me.jvegaf.challenge.application.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.jvegaf.challenge.domain.price.FindPrice;
import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceRepository;

import java.time.Instant;
import java.util.Optional;

public class FindPriceUseCase implements FindPrice {

  private final Logger logger = LoggerFactory.getLogger(FindPriceUseCase.class);

  private final PriceRepository priceRepository;

  public FindPriceUseCase(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public Optional<Price> findPriceByCriteria(Instant date, Long productId, Long brandId) {

    logger.info("start params date: {}, productId: {}, brandId: {}", date, productId, brandId);

    Optional<Price> priceOptional = priceRepository.findPriceByCriteria(date, productId, brandId);

    logger.info("price found: {}", priceOptional.isPresent());

    return priceOptional;
  }
}
