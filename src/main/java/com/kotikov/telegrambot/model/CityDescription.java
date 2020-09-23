package com.kotikov.telegrambot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Telegrambot_City_Description")
@Getter
@Setter
public class CityDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_description")
    private String description;

    @ManyToOne
    @JoinColumn(name="city_id",nullable = false)
    private City city;
}
