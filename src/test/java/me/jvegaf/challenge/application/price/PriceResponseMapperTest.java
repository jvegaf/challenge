package me.jvegaf.challenge.application.price;

import me.jvegaf.challenge.application.price.PriceResponse;
import me.jvegaf.challenge.application.price.PriceResponseMapper;
import me.jvegaf.challenge.domain.price.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class PriceResponseMapperTest {


    // Should map a valid Price object to a valid PriceResponse object
    @Test
    public void test_mapValidPriceToValidPriceResponse() {
        Price price = Price.newBuilder()
                .withId(1L)
                .withProductId(2L)
                .withBrandId(3L)
                .withStartDate(Instant.now())
                .withEndDate(Instant.now().plus(Duration.ofDays(1)))
                .withPrice(new BigDecimal("10.00"))
                .withPriceList(4)
                .build();

        PriceResponseMapper mapper = new PriceResponseMapper();
        PriceResponse response = mapper.toResponse(price);

        assertEquals(price.getId(), response.id());
        assertEquals(price.getProductId(), response.productId());
        assertEquals(price.getBrandId(), response.brandId());
        assertEquals(price.getStartDate(), response.startDate());
        assertEquals(price.getEndDate(), response.endDate());
        assertEquals(price.getPrice(), response.price());
        assertEquals(price.getPriceList(), response.priceList());
    }

    // Should map a Price object with null fields to a valid PriceResponse object with null fields
    @Test
    public void test_mapNullFieldsToNullFields() {
        Price price = Price.newBuilder().build();

        PriceResponseMapper mapper = new PriceResponseMapper();
        PriceResponse response = mapper.toResponse(price);

        assertNull(response.id());
        assertNull(response.productId());
        assertNull(response.brandId());
        assertNull(response.startDate());
        assertNull(response.endDate());
        assertNull(response.price());
        assertNull(response.priceList());
    }

    // Should map a Price object with non-null fields to a valid PriceResponse object with non-null fields
    @Test
    public void test_mapNonNullFieldsToNonNullFields() {
        Price price = Price.newBuilder()
                .withId(1L)
                .withProductId(2L)
                .withBrandId(3L)
                .withStartDate(Instant.now())
                .withEndDate(Instant.now().plus(Duration.ofDays(1)))
                .withPrice(new BigDecimal("10.00"))
                .withPriceList(4)
                .build();

        PriceResponseMapper mapper = new PriceResponseMapper();
        PriceResponse response = mapper.toResponse(price);

        assertNotNull(response.id());
        assertNotNull(response.productId());
        assertNotNull(response.brandId());
        assertNotNull(response.startDate());
        assertNotNull(response.endDate());
        assertNotNull(response.price());
        assertNotNull(response.priceList());
    }

    // Should map a Price object with null fields to a valid PriceResponse object with non-null fields
    @Test
    public void test_mapNullFieldsToNonNullFields() {
        Price price = Price.newBuilder().build();

        PriceResponseMapper mapper = new PriceResponseMapper();
        PriceResponse response = mapper.toResponse(price);

        assertNull(response.id());
        assertNull(response.productId());
        assertNull(response.brandId());
        assertNull(response.startDate());
        assertNull(response.endDate());
        assertNull(response.price());
        assertNull(response.priceList());
    }


    // Should map a Price object with null id to a valid PriceResponse object with null id
    @Test
    public void test_mapNullIdToNullId() {
        Price price = Price.newBuilder().build();

        PriceResponseMapper mapper = new PriceResponseMapper();
        PriceResponse response = mapper.toResponse(price);

        assertNull(response.id());
    }

}