package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.CityDescription;

public interface CityDescriptionService {

    CityDescription getById(Long id);

    void delete(Long id);

    void save(CityDescription cityDescription);
}
