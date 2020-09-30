package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.enums.MsgType;
import com.kotikov.telegrambot.model.City;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

public interface CityService {
    City getById(Long id);

    void delete(Long id);

    void save(City city);

    List<City> getAll();

    List<City> findByCityNameOrPartOfName(String name);

    String responseMsg(Message message, MsgType msgType);
}
