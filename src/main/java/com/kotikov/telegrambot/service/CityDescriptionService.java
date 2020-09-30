package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.model.CityDescription;

import java.util.List;

public interface CityDescriptionService {

    CityDescription getById(Long id);

    void delete(Long id);

    void save(CityDescription cityDescription);

    List<CityDescription> getAll();
}
