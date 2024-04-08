package me.jvegaf.challenge.infra.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceRepository;

import java.time.Instant;
import java.util.Optional;

public class PriceRepositoryAdapter implements PriceRepository {

  private final Logger logger = LoggerFactory.getLogger(PriceRepositoryAdapter.class);

  private final JpaPriceRepository repository;

  private final PriceEntityMapper mapper;

  public PriceRepositoryAdapter(JpaPriceRepository repository, PriceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Optional<Price> findPriceByCriteria(Instant date, Long productId, Long brandId) {

    logger.info("start params date: {}, productId: {}, brandId: {}", date, productId, brandId);

    Optional<PriceEntity> priceEntityByCriteria = repository.findPriceByCriteria(date, productId, brandId);

    Optional<Price> priceOptional = priceEntityByCriteria.map(mapper::toDomain);

    logger.info("price founded: {}", priceOptional.isPresent());

    return priceOptional;
  }
}
