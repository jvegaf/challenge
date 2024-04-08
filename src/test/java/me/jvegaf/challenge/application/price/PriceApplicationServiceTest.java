package me.jvegaf.challenge.application.price;


import me.jvegaf.challenge.domain.price.FindPrice;
import me.jvegaf.challenge.domain.price.Price;
import me.jvegaf.challenge.domain.price.PriceNotFound;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Currency;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceApplicationServiceTest {
    // Returns a valid PriceResponse when given valid input
    @Test
    public void test_returns_valid_price_response() {
        // Create mock objects
        FindPrice findPriceUseCase = mock(FindPrice.class);
        PriceResponseMapper mapper = mock(PriceResponseMapper.class);
    
        // Create test data
        PriceRequest priceRequest = new PriceRequest(
            Instant.now(),
            1L,
            1L
        );
        Price price = Price.newBuilder()
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
        Optional<Price> result = Optional.of(price);
        PriceResponse expectedResponse = new PriceResponse(
            price.getId(),
            price.getProductId(),
            price.getBrandId(),
            price.getStartDate(),
            price.getEndDate(),
            price.getPrice(),
            price.getPriceList()
        );
    
        // Set up mock behavior
        when(findPriceUseCase.findPriceByCriteria(any(), any(), any()))
            .thenReturn(result);
        when(mapper.toResponse(any()))
            .thenReturn(expectedResponse);
    
        // Create instance of PriceApplicationService
        PriceApplicationService priceApplicationService = new PriceApplicationService(findPriceUseCase, mapper);
    
        // Call the method under test
        PriceResponse actualResponse = priceApplicationService.findPriceByCriteria(priceRequest);
    
        // Verify the result
        assertEquals(expectedResponse, actualResponse);
    }

    // Throws PriceNotFound when no price is found for given input
    @Test
    public void test_priceNotFound_whenNoPriceFound() {
        // Arrange
        FindPrice findPriceUseCase = mock(FindPrice.class);
        PriceResponseMapper mapper = mock(PriceResponseMapper.class);
        PriceApplicationService priceApplicationService = new PriceApplicationService(findPriceUseCase, mapper);
        PriceRequest priceRequest = new PriceRequest(Instant.now(), 1L, 1L);
    
        // Act
        when(findPriceUseCase.findPriceByCriteria(any(Instant.class), anyLong(), anyLong())).thenReturn(Optional.empty());
    
        // Assert
        assertThrows(PriceNotFound.class, () -> priceApplicationService.findPriceByCriteria(priceRequest));
    }

    // Logs start and finish of the method with correct parameters
    @Test
    public void test_logs_start_and_finish_with_correct_parameters() {
        // Create mock objects
        FindPrice findPriceUseCase = mock(FindPrice.class);
        PriceResponseMapper mapper = mock(PriceResponseMapper.class);
    
        // Create test data
        PriceRequest priceRequest = new PriceRequest(
            Instant.now(),
            1L,
            1L
        );
        Optional<Price> result = Optional.of(Price.newBuilder()
            .withId(1L)
            .withBrandId(1L)
            .withStartDate(Instant.now())
            .withEndDate(Instant.now().plus(Duration.ofDays(1)))
            .withProductId(1L)
            .withPriority(1L)
            .withPrice(BigDecimal.valueOf(10.0))
            .withCurrency(Currency.getInstance("USD"))
            .withPriceList(1)
            .build());
    
        // Mock the behavior of findPriceByCriteria method
        when(findPriceUseCase.findPriceByCriteria(any(), any(), any()))
            .thenReturn(result);
    
        // Mock the behavior of toResponse method
        when(mapper.toResponse(any()))
            .thenReturn(new PriceResponse(
                1L,
                1L,
                1L,
                Instant.now(),
                Instant.now().plus(Duration.ofDays(1)),
                BigDecimal.valueOf(10.0),
                1
            ));
    
        // Create an instance of PriceApplicationService
        PriceApplicationService priceApplicationService = new PriceApplicationService(findPriceUseCase, mapper);
    
        // Call the findPriceByCriteria method
        PriceResponse priceResponse = priceApplicationService.findPriceByCriteria(priceRequest);
    
        // Verify the behavior
        Mockito.verify(findPriceUseCase).findPriceByCriteria(any(), any(), any());
        Mockito.verify(mapper).toResponse(any());
    
        // Assert the result
        assertNotNull(priceResponse);
    
        // Add additional assertions if needed
    
    }
}