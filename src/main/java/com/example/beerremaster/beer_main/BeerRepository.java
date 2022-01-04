package com.example.beerremaster.beer_main;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    List<Beer> findAllByName(String name);

    List<Beer> findAllByPriceBeforeOrderByPrice(BigDecimal priceBefore);

}
