package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.model.CityDescription;
import com.kotikov.telegrambot.repository.CityDescriptionRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CityDescriptionServiceImplementation implements CityDescriptionService {
    @Autowired
    private CityDescriptionRepository cityDescriptionRepository;

    @Override
    public CityDescription getById(Long id) {
        return cityDescriptionRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        cityDescriptionRepository.deleteById(id);
    }

    @Override
    @Deprecated
    public void save(CityDescription cityDescription) {
        cityDescriptionRepository.save(cityDescription);
    }
}
