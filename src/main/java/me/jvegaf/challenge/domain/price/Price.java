package me.jvegaf.challenge.domain.price;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

@Getter
public final class Price {
  private final Long id;
  private final Long brandId;
  private final Instant startDate;
  private final Instant endDate;
  private final Long productId;
  private final Long priority;
  private final BigDecimal price;
  private final Currency currency;
  private final Integer priceList;


  private Price(Builder builder) {
    id = builder.id;
    brandId = builder.brandId;
    startDate = builder.startDate;
    endDate = builder.endDate;
    productId = builder.productId;
    priority = builder.priority;
    price = builder.price;
    currency = builder.currency;
    priceList = builder.priceList;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private Long id;
    private Long brandId;
    private Instant startDate;
    private Instant endDate;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private Currency currency;
    private Integer priceList;

    private Builder() {
    }

    public Builder withId(Long val) {
      id = val;
      return this;
    }

    public Builder withBrandId(Long val) {
      brandId = val;
      return this;
    }

    public Builder withStartDate(Instant val) {
      startDate = val;
      return this;
    }

    public Builder withEndDate(Instant val) {
      endDate = val;
      return this;
    }

    public Builder withProductId(Long val) {
      productId = val;
      return this;
    }

    public Builder withPriority(Long val) {
      priority = val;
      return this;
    }

    public Builder withPrice(BigDecimal val) {
      price = val;
      return this;
    }

    public Builder withCurrency(Currency val) {
      currency = val;
      return this;
    }

    public Builder withPriceList(Integer val) {
      priceList = val;
      return this;
    }

    public Price build() {
      return new Price(this);
    }
  }
}
