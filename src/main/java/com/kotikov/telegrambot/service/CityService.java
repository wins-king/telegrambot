package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.City;
import org.springframework.stereotype.Service;

@Service
public interface CityService {
    City getById(Long id);

    void delete(Long id);

    void save(City city);
}
