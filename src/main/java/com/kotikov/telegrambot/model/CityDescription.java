package com.kotikov.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Telegrambot_City_Description")
@Data
public class CityDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_description")
    private String description;

    @ManyToOne
    @JoinColumn(name="city_id",nullable = false)
    @ToString.Exclude @JsonIgnore
    private City city;
}
