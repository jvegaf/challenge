package me.jvegaf.challenge.infra.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceRepository;

import java.time.Instant;
import java.util.List;

public class PriceRepositoryAdapter implements PriceRepository {

  private final Logger logger = LoggerFactory.getLogger(PriceRepositoryAdapter.class);

  private final JpaPriceRepository repository;

  private final PriceEntityMapper mapper;

  public PriceRepositoryAdapter(JpaPriceRepository repository, PriceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<Price> findPriceByCriteria(Instant date, Long productId, Long brandId) {

    logger.info("start params date: {}, productId: {}, brandId: {}", date, productId, brandId);

    List<PriceEntity> priceEntityByCriteria = repository.findPriceByCriteria(date, productId, brandId);

    List<Price> prices = priceEntityByCriteria.stream().map(mapper::toDomain).toList();

    logger.info("return prices size: {}", prices.size());

    return prices;
  }
}
