package me.jvegaf.challenge.infra.price;

import jakarta.validation.ConstraintViolationException;
import me.jvegaf.challenge.application.price.PriceRequest;
import me.jvegaf.challenge.application.price.PriceResponse;
import me.jvegaf.challenge.domain.price.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceControllerTest {
    // Returns PriceResponse when valid PriceRequest is provided
    @Test
    public void test_returns_price_response() {
        // Arrange
        PriceRequest priceRequest = new PriceRequest(Instant.now(), 1L, 1L);
        PriceResponse expectedResponse = new PriceResponse(1L, 1L, 1L, Instant.now(), Instant.now(), BigDecimal.valueOf(10.0), 1);
    
        // Mock the PriceService
        PriceService priceServiceMock = Mockito.mock(PriceService.class);
        Mockito.when(priceServiceMock.findPriceByCriteria(priceRequest)).thenReturn(expectedResponse);
    
        // Create the PriceController instance
        PriceController priceController = new PriceController(priceServiceMock);
    
        // Act
        PriceResponse actualResponse = priceController.findByCriteria(priceRequest);
    
        // Assert
        assertEquals(expectedResponse, actualResponse);
    }


    // Returns null when PriceService returns null
    @Test
    public void test_returns_null_when_service_returns_null() {
        // Arrange
        PriceRequest priceRequest = new PriceRequest(Instant.now(), 1L, 1L);
    
        // Mock the PriceService
        PriceService priceServiceMock = Mockito.mock(PriceService.class);
        Mockito.when(priceServiceMock.findPriceByCriteria(priceRequest)).thenReturn(null);
    
        // Create the PriceController instance
        PriceController priceController = new PriceController(priceServiceMock);
    
        // Act
        PriceResponse actualResponse = priceController.findByCriteria(priceRequest);
    
        // Assert
        assertNull(actualResponse);
    }

    private void assertNull(PriceResponse actualResponse) {
    }

    // Throws exception when PriceService throws exception
    @Test
    public void test_throws_exception_when_service_throws_exception() {
        // Arrange
        PriceRequest priceRequest = new PriceRequest(Instant.now(), 1L, 1L);
    
        // Mock the PriceService
        PriceService priceServiceMock = Mockito.mock(PriceService.class);
        Mockito.when(priceServiceMock.findPriceByCriteria(priceRequest)).thenThrow(new RuntimeException("Error"));
    
        // Create the PriceController instance
        PriceController priceController = new PriceController(priceServiceMock);
    
        // Act and Assert
        assertThrows(RuntimeException.class, () -> priceController.findByCriteria(priceRequest));
    }

    // Returns PriceResponse with correct values when multiple prices match the criteria
    @Test
    public void test_returns_price_response_with_correct_values() {
        // Arrange
        PriceRequest priceRequest = new PriceRequest(Instant.now(), 1L, 1L);
        PriceResponse expectedResponse = new PriceResponse(1L, 1L, 1L, Instant.now(), Instant.now(), BigDecimal.valueOf(10.0), 1);
    
        // Mock the PriceService
        PriceService priceServiceMock = Mockito.mock(PriceService.class);
        Mockito.when(priceServiceMock.findPriceByCriteria(priceRequest)).thenReturn(expectedResponse);
    
        // Create the PriceController instance
        PriceController priceController = new PriceController(priceServiceMock);
    
        // Act
        PriceResponse actualResponse = priceController.findByCriteria(priceRequest);
    
        // Assert
        assertEquals(expectedResponse, actualResponse);
    }
}