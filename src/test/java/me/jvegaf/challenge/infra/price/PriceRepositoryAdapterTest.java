package me.jvegaf.challenge.infra.price;

import me.jvegaf.challenge.domain.price.Price;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceRepositoryAdapterTest {
    // Should return an empty list when no prices are found for given date, productId, and brandId
    @Test
    public void test_return_empty_list_when_no_prices_found() {
        // Mock the dependencies
        JpaPriceRepository repository = mock(JpaPriceRepository.class);
        PriceEntityMapper mapper = mock(PriceEntityMapper.class);

        // Create test data
        Instant date = Instant.now();
        Long productId = 1L;
        Long brandId = 1L;
        Optional<PriceEntity> priceEntity = Optional.empty();
        when(repository.findPriceByCriteria(date, productId, brandId)).thenReturn(priceEntity);

        // Create the adapter instance
        PriceRepositoryAdapter adapter = new PriceRepositoryAdapter(repository, mapper);

        // Call the method under test
        Optional<Price> price = adapter.findPriceByCriteria(date, productId, brandId);

        // Verify the result
        assertTrue(price.isEmpty());
    }

    // Should handle null productId parameter and return an empty list
    @Test
    public void test_handle_null_productId_parameter() {
        // Create mock objects
        JpaPriceRepository mockRepository = mock(JpaPriceRepository.class);
        PriceEntityMapper mockMapper = mock(PriceEntityMapper.class);

        // Create the PriceRepositoryAdapter instance with the mock objects
        PriceRepositoryAdapter adapter = new PriceRepositoryAdapter(mockRepository, mockMapper);

        // Set up the mock repository to return an empty list when findPriceByCriteria is called with null productId
        when(mockRepository.findPriceByCriteria(Mockito.any(), Mockito.isNull(), Mockito.any()))
                .thenReturn(Optional.empty());

        // Call the method under test with null productId
        Optional<Price> result = adapter.findPriceByCriteria(Instant.now(), null, 1L);

        // Verify that the mock repository method was called with the correct parameters
        Mockito.verify(mockRepository).findPriceByCriteria(Mockito.any(), Mockito.isNull(), Mockito.any());

        // Verify that the result is an empty list
        assertTrue(result.isEmpty());
    }

    // Should handle a single result found for given date, productId, and brandId
    @Test
    public void test_handle_single_result() {
        // Create mock objects
        JpaPriceRepository mockRepository = mock(JpaPriceRepository.class);
        PriceEntityMapper mockMapper = mock(PriceEntityMapper.class);

        // Create test data
        Instant date = Instant.now();
        Long productId = 1L;
        Long brandId = 1L;
        Optional<PriceEntity> priceEntity = Optional.of(new PriceEntity.Builder()
                .withId(1L)
                .withBrandId(brandId)
                .withStartDate(date.minusSeconds(10))
                .withEndDate(date.plusSeconds(10))
                .withProductId(productId)
                .withPriority(1L)
                .withPrice(BigDecimal.valueOf(10.0))
                .withCurrency(Currency.getInstance("USD"))
                .withPriceList(1)
                .build());
        Price price = new Price.Builder()
                .withId(1L)
                .withBrandId(brandId)
                .withStartDate(date.minusSeconds(10))
                .withEndDate(date.plusSeconds(10))
                .withProductId(productId)
                .withPriority(1L)
                .withPrice(BigDecimal.valueOf(10.0))
                .withCurrency(Currency.getInstance("USD"))
                .withPriceList(1)
                .build();

        // Configure mock objects
        when(mockRepository.findPriceByCriteria(date, productId, brandId)).thenReturn(priceEntity);
        when(mockMapper.toDomain(priceEntity.get())).thenReturn(price);

        // Create instance of PriceRepositoryAdapter
        PriceRepositoryAdapter adapter = new PriceRepositoryAdapter(mockRepository, mockMapper);

        // Call the method under test
        Optional<Price> result = adapter.findPriceByCriteria(date, productId, brandId);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(price, result.get());

        // Verify the method calls on mock objects
        Mockito.verify(mockRepository).findPriceByCriteria(date, productId, brandId);
        Mockito.verify(mockMapper).toDomain(priceEntity.get());
    }
}
