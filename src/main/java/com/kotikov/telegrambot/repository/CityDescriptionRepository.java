package com.kotikov.telegrambot.repository;

import com.kotikov.telegrambot.model.CityDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDescriptionRepository extends JpaRepository<CityDescription, Long> {
}
