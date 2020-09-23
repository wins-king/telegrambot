package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.repository.CityRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CityServiceImplementation implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getById(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }
}
