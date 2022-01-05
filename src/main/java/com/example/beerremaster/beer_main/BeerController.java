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
    public List<BeerDTO> getAllBeer() {
        return beerService.getAllBeer()
                .stream()
                .map(beerConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/pricing")
    public List<BeerDTO> getAllBeerByPrice() {
        return beerService.getUnderPrice()
                .stream()
                .map(beerConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public List<BeerDTO> saveBeer(@RequestBody List<BeerDTO> payload) {
        List<Beer> collectedPayload = payload.stream()
                .map(beerConverter::convertDtoToEntity)
                .collect(Collectors.toList());
        return beerService.saveBeerList(collectedPayload)
                .stream()
                .map(beerConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public void deleteBeer(@RequestParam(name="name") String name) {
        beerService.deleteByName(name);
    }
}
