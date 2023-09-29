package me.jvegaf.challenge.infra.price;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;

@Getter
@Entity
@Table(name = "PRICES", indexes = {
    @Index(name = "pricesSearchIndex", columnList = "startDate, endDate, productId, brandId") }, uniqueConstraints = {
        @UniqueConstraint(name = "UniqueStartAndDateEndDateAndPriorityAndProductIdAndBrandId", columnNames = {
            "startDate", "endDate", "priority", "productId", "brandId" }) })
public final class PriceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Long brandId;
  @Column(nullable = false)
  private Instant startDate;
  @Column(nullable = false)
  private Instant endDate;
  @Column(nullable = false)
  private Long productId;
  @Column(nullable = false)
  private Long priority;
  @Column(nullable = false)
  private BigDecimal price;
  @Column(nullable = false)
  private Currency currency;

  private Integer priceList;

  public PriceEntity() {
  }

  private PriceEntity(Builder builder) {
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

    public PriceEntity build() {
      return new PriceEntity(this);
    }
  }
}
