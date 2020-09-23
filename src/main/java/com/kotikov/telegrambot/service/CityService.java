package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.City;

public interface CityService {
    City getById(Long id);

    void delete(Long id);

    void save(City city);
}
