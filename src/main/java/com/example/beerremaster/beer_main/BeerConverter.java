package com.example.beerremaster.beer_main;

import org.springframework.stereotype.Component;

@Component
public class BeerConverter {
    private Boolean defaultIsVegetarianValue = true;
    private Integer defaultVolumeValue = 500;

    public BeerConverter() {
    }

    public BeerConverter(Boolean defaultIsVegetarianValue, Integer defaultVolumeValue) {
        this.defaultIsVegetarianValue = defaultIsVegetarianValue;
        this.defaultVolumeValue = defaultVolumeValue;
    }

    public Boolean getDefaultIsVegetarianValue() {
        return defaultIsVegetarianValue;
    }

    public void setDefaultIsVegetarianValue(Boolean defaultIsVegetarianValue) {
        this.defaultIsVegetarianValue = defaultIsVegetarianValue;
    }

    public Integer getDefaultVolumeValue() {
        return defaultVolumeValue;
    }

    public void setDefaultVolumeValue(Integer defaultVolumeValue) {
        this.defaultVolumeValue = defaultVolumeValue;
    }

    public Beer convertDtoToEntity(BeerDTO beerDTO) {
        return new Beer(
                beerDTO.getName(),
                beerDTO.getStrength(),
                (beerDTO.Is_veggie() == null) ? defaultIsVegetarianValue : beerDTO.Is_veggie(),
                (beerDTO.getVolume() == null) ? defaultVolumeValue : beerDTO.getVolume(),
                beerDTO.getPrice()
        );
    }

    public BeerDTO convertEntityToDto(Beer beer) {
        return new BeerDTO(
            beer.getName(),
            beer.getStrength(),
            beer.getVolume(),
            beer.getPrice(),
            beer.getVegeterian()
        );
    }
}
