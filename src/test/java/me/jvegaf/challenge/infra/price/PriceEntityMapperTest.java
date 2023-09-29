package me.jvegaf.challenge.infra.price;

import me.jvegaf.challenge.domain.price.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PriceEntityMapperTest {


    // Translates a valid PriceEntity to a Price object
    @Test
    public void test_translates_valid_price_entity() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withId(1L)
            .withBrandId(1L)
            .withStartDate(Instant.now())
            .withEndDate(Instant.now().plus(Duration.ofDays(1)))
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.valueOf(10.0))
            .withCurrency(Currency.getInstance("USD"))
            .withPriceList(1)
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
    }

    // Translates a PriceEntity with all fields set to the minimum valid values to a Price object
    @Test
    public void test_translates_price_entity_with_minimum_values() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withId(1L)
            .withBrandId(1L)
            .withStartDate(Instant.MIN)
            .withEndDate(Instant.MIN)
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.ZERO)
            .withCurrency(Currency.getInstance("USD"))
            .withPriceList(1)
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
    }

    // Translates a PriceEntity with all fields set to the maximum valid values to a Price object
    @Test
    public void test_translates_price_entity_with_maximum_values() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withId(Long.MAX_VALUE)
            .withBrandId(Long.MAX_VALUE)
            .withStartDate(Instant.MAX)
            .withEndDate(Instant.MAX)
            .withProductId(Long.MAX_VALUE)
            .withPriority(Long.MAX_VALUE)
            .withPrice(BigDecimal.valueOf(Double.MAX_VALUE))
            .withCurrency(Currency.getInstance("USD"))
            .withPriceList(Integer.MAX_VALUE)
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
    }

    // Translates a PriceEntity with null priceList to a Price object
    @Test
    public void test_translates_price_entity_with_null_price_list() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withId(1L)
            .withBrandId(1L)
            .withStartDate(Instant.now())
            .withEndDate(Instant.now().plus(Duration.ofDays(1)))
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.valueOf(10.0))
            .withCurrency(Currency.getInstance("USD"))
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertNull(price.getPriceList());
    }

    // Translates a PriceEntity with null currency to a Price object
    @Test
    public void test_translates_price_entity_with_null_currency() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withId(1L)
            .withBrandId(1L)
            .withStartDate(Instant.now())
            .withEndDate(Instant.now().plus(Duration.ofDays(1)))
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.valueOf(10.0))
            .withPriceList(1)
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertNull(price.getCurrency());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
    }

    // Translates a PriceEntity with null id to a Price object
    @Test
    public void test_translates_price_entity_with_null_id() {
        PriceEntityMapper priceEntityMapper = new PriceEntityMapper();
        PriceEntity priceEntity = new PriceEntity.Builder()
            .withBrandId(1L)
            .withStartDate(Instant.now())
            .withEndDate(Instant.now().plus(Duration.ofDays(1)))
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.valueOf(10.0))
            .withCurrency(Currency.getInstance("USD"))
            .withPriceList(1)
            .build();

        Price price = priceEntityMapper.toDomain(priceEntity);

        assertNull(price.getId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
    }

}