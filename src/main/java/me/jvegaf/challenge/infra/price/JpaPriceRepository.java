package me.jvegaf.challenge.infra.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query("SELECT p FROM PriceEntity p " +
      "where p.startDate<= ?1 and p.endDate >= ?1 and p.productId= ?2 and p.brandId= ?3 " +
      "ORDER BY p.priority DESC LIMIT 2")
  List<PriceEntity> findPriceByCriteria(Instant date, Long productId, Long brandId);

}
