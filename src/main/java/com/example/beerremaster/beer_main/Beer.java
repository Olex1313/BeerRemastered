package com.example.beerremaster.beer_main;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "beer_base")
public class Beer {
    @Id
    @Column(name = "beer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long beerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "strength", nullable = false)
    private Integer strength;

    @Column(
        name = "is_vegetarian",
        nullable = false,
        columnDefinition = "boolean default true"
    )
    private Boolean isVegetarian;

    @Column(
        name = "volume",
        nullable = false,
        columnDefinition = "integer default 500"
    )
    private Integer volume;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public Beer() {
    }

    public Beer(String name, Integer strength, Boolean isVegetarian, Integer volume, BigDecimal price) {
        this.name = name;
        this.strength = strength;
        this.isVegetarian = isVegetarian;
        this.volume = volume;
        this.price = price;
    }

    public Beer(Long beerId, String name, Integer strength, Boolean isVegetarian, Integer volume, BigDecimal price) {
        this.beerId = beerId;
        this.name = name;
        this.strength = strength;
        this.isVegetarian = isVegetarian;
        this.volume = volume;
        this.price = price;
    }

    public Beer(String name, Integer strength, Integer volume, BigDecimal price) {
        this.name = name;
        this.strength = strength;
        this.volume = volume;
        this.price = price;
        this.isVegetarian = true;
    }

    public Long getBeerId() {
        return beerId;
    }

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }

    public Boolean getVegeterian() {
        return isVegetarian;
    }

    public Integer getVolume() {
        return volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", isVegetarian=" + isVegetarian +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }
}
