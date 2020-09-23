package com.kotikov.telegrambot.repository;

import com.kotikov.telegrambot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
