package com.example.beerremaster.beer_main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    private final BeerConverter beerConverter;

    @Autowired
    public BeerController(BeerService beerService, BeerConverter converter) {
        this.beerConverter = converter;
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> getAllBeer() {
        return beerService.getAllBeer();
    }

    @GetMapping(path = "/pricing")
    public List<Beer> getAllBeerByPrice() {
        return beerService.getUnderPrice();
    }

    @PostMapping
    public List<Beer> saveBeer(@RequestBody List<BeerDTO> payload) {
        List<Beer> collectedPayload = payload.stream()
                .map((dto) -> beerConverter.convertDtoToEntity(dto))
                .collect(Collectors.toList());
        return beerService.saveBeerList(collectedPayload);
    }

}
