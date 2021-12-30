package com.example.beerremaster.beer_main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class BeerConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            BeerRepository beerRepository
    ) {
        return args -> beerRepository.save(new Beer(
                        1L,
                        "Imperial stout",
                        7,
                        true,
                        500,
                        BigDecimal.valueOf(180)
                )
        );
    }
}
