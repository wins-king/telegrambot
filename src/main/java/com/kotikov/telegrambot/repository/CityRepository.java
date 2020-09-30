package com.kotikov.telegrambot.repository;

import com.kotikov.telegrambot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    @Query("select distinct c from City c join fetch c.setDescriptions where upper(c.name) like %:name% ")
    List<City> findByCityNameOrPartOfName(String name);
}
