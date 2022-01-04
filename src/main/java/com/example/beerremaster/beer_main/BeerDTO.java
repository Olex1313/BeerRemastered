package com.example.beerremaster.beer_main;

import java.math.BigDecimal;

public class BeerDTO {
    private String name;
    private Integer strength;
    private Integer volume = 500;
    private BigDecimal price;
    private Boolean is_vegetarian = true;

    public BeerDTO(String name, Integer strength, Integer volume, BigDecimal price, Boolean is_vegetarian) {
        this.name = name;
        this.strength = strength;
        this.volume = volume;
        this.price = price;
        this.is_vegetarian = is_vegetarian;
    }

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getVolume() {
        return volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean Is_veggie() {
        return is_vegetarian;
    }
}
