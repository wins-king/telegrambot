package com.kotikov.telegrambot.service;

import com.kotikov.telegrambot.enums.MsgType;
import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.repository.CityRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImplementation implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getById(Long id) {
        try {
            Optional<City> cityOptional = cityRepository.findById(id);
            if(cityOptional.isPresent()){
                return cityOptional.get();
            }else return null;
        }catch(EntityNotFoundException e){
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void save(City city) {
        if(city.getSetDescriptions()!=null){
            city.getSetDescriptions().forEach((description)->{
                description.setCity(city);
            });
        }
        cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findByCityNameOrPartOfName(String name) {
        List<City> cityList = cityRepository.findByCityNameOrPartOfName(name);
        return cityList;
    }

    @Override
    public String responseMsg(Message message, MsgType type) {
        try {
            switch (type){
                case CITY_INFO:
                    List<City> cityList = this.findByCityNameOrPartOfName(message.getText());
                    if(cityList==null || cityList.size()==0){
                        StringBuilder sb = new StringBuilder("City not found!\n");
                        sb.append(this.getAll().stream().map(c->c.getName()).collect(Collectors.joining("\n","Full list of cities below:\n","\nPlease choose one of them.")));
                        return sb.toString();
                    }else if(cityList.size()>1){
                        StringBuilder sb = new StringBuilder("More then one city found:\n");
                        sb.append(cityList.stream().map(c->c.getName()).collect(Collectors.joining("\n")));
                        return sb.toString();
                    }else{
                        Hibernate.initialize(cityList.get(0).getSetDescriptions());
                        return cityList.stream()
                                .flatMap(cities -> cities.getSetDescriptions().stream().map(c->c.getDescription()))
                                .collect(Collectors.joining("\n"));
                    }
                case UNSUPPORTABLE:
                    return "unsupportable type of message";
                default: return "";
            }
        }catch (Exception ex){
            return "Sorry, I can't send response. Something went wrong ";
        }
    }
}
