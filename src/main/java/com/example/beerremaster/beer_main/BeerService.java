package com.example.beerremaster.beer_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
