package com.example.beerremaster.beer_main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer findByName(String name);

    List<Beer> findAllByPriceBeforeOrderByPrice(BigDecimal priceBefore);

}
