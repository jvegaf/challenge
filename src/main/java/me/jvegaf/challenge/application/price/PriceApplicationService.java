
package me.jvegaf.challenge.application.price;

import me.jvegaf.challenge.domain.price.FindPrice;
import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceNotFound;
import me.jvegaf.challenge.domain.price.PriceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class PriceApplicationService implements PriceService {
  private final Logger logger = LoggerFactory.getLogger(PriceApplicationService.class);
  private final FindPrice findPriceUseCase;
  private final PriceResponseMapper mapper;

  public PriceApplicationService(FindPrice findPriceUseCase, PriceResponseMapper mapper) {
    this.findPriceUseCase = findPriceUseCase;
    this.mapper = mapper;
  }

  public PriceResponse findPriceByCriteria(PriceRequest priceRequest) {

    logger.info("start with params: {}", priceRequest);

    Optional<Price> result = findPriceUseCase.findPriceByCriteria(priceRequest.applicationDate(),
                                                                  priceRequest.productId(), priceRequest.brandId());


    PriceResponse priceResponse = result.map(mapper::toResponse)
        .orElseThrow(PriceNotFound::new);

    logger.info("finish return {}:", priceResponse);

    return priceResponse;

  }
}
