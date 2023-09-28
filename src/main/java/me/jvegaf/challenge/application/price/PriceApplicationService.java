
package me.jvegaf.challenge.application.price;

import me.jvegaf.challenge.domain.price.FindPrice;
import me.jvegaf.challenge.domain.price.ManyPricesFound;
import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceNotFound;
import me.jvegaf.challenge.domain.price.PriceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    List<Price> result = findPriceUseCase.findPriceByCriteria(priceRequest.applicationDate(),
        priceRequest.productId(), priceRequest.brandId());

    validateResult(result);

    PriceResponse priceResponse = result.stream().map(mapper::toResponse).findFirst()
        .orElseThrow(() -> new PriceNotFound());

    logger.info("finish return {}:", priceResponse);

    return priceResponse;

  }

  private static void validateResult(List<Price> result) {

    if (result.size() >= 2 && result.stream()
        .allMatch(price -> result.stream().findFirst().get().getPriority().equals(price.getPriority()))) {
      throw new ManyPricesFound();
    }
  }

}
