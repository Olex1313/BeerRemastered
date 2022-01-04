package com.example.beerremaster.beer_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository repository) {
        beerRepository = repository;
    }
    public List<Beer> getAllBeer() {
        return beerRepository.findAll();
    }

    public List<Beer> getUnderPrice() {
        return beerRepository.findAllByPriceBeforeOrderByPrice(BigDecimal.valueOf(100));
    }

    public List<Beer> saveBeerList(List<Beer> incomingBeer) {
        return beerRepository.saveAllAndFlush(incomingBeer);
    }
}
