
package me.jvegaf.challenge.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.jvegaf.challenge.application.price.FindPriceUseCase;
import me.jvegaf.challenge.application.price.PriceApplicationService;
import me.jvegaf.challenge.application.price.PriceResponseMapper;
import me.jvegaf.challenge.domain.price.FindPrice;
import me.jvegaf.challenge.domain.price.PriceRepository;
import me.jvegaf.challenge.domain.price.PriceService;
import me.jvegaf.challenge.infra.price.JpaPriceRepository;
import me.jvegaf.challenge.infra.price.PriceEntityMapper;
import me.jvegaf.challenge.infra.price.PriceRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public FindPrice findPriceUseCase(PriceRepository repository) {
        return new FindPriceUseCase(repository);
    }

    @Bean
    public PriceRepository priceRepository(JpaPriceRepository repository, PriceEntityMapper mapper) {
        return new PriceRepositoryAdapter(repository, mapper);
    }

    @Bean
    public PriceService priceService(PriceRepository priceRepository, FindPrice findPriceUseCase, PriceResponseMapper mapper) {
        return new PriceApplicationService(new FindPriceUseCase(priceRepository), mapper);
    }

    @Bean
    public PriceResponseMapper priceResponseMapper() {
        return new PriceResponseMapper();
    }

    @Bean
    public PriceEntityMapper priceEntityMapper() {
        return new PriceEntityMapper();
    }


}
