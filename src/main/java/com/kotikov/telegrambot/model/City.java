package com.kotikov.telegrambot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Telegrambot_City")
@Data
@EqualsAndHashCode(exclude="setDescriptions")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<CityDescription> setDescriptions;


}
