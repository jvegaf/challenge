package me.jvegaf.challenge.infra.price;

import jakarta.validation.Valid;
import me.jvegaf.challenge.application.price.PriceRequest;
import me.jvegaf.challenge.application.price.PriceResponse;
import me.jvegaf.challenge.domain.price.PriceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/prices")
@Validated
public class PriceController {

    private final Logger logger = LoggerFactory.getLogger(PriceController.class);

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public PriceResponse findByCriteria(@Valid PriceRequest priceRequest) {

        logger.info("start params {}", priceRequest);

        PriceResponse priceResponse = priceService.findPriceByCriteria(priceRequest);

        logger.info("finish return {}", priceRequest);

        return priceResponse;
    }

}
