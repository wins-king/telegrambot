package com.kotikov.telegrambot.rest;

import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/city/")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityCity(@PathVariable("id") Long id ){
        if(id==null){
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }
        City city = cityService.getById(id);
        if(city==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> deleteCity(@PathVariable("id") Long id ){
        if(id==null){
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value="",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@RequestBody @Valid City city){
        if(city==null){
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @RequestMapping(value="",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@RequestBody @Valid City city){
        if(city==null){
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }


}
