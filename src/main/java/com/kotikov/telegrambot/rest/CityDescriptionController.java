package com.kotikov.telegrambot.rest;

import com.kotikov.telegrambot.model.City;
import com.kotikov.telegrambot.model.CityDescription;
import com.kotikov.telegrambot.service.CityDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cityDescription/")
public class CityDescriptionController {

    @Autowired
    private CityDescriptionService cityDescriptionService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDescription> getCityDescription(@PathVariable("id") Long id ){
        if(id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CityDescription cityDescription = cityDescriptionService.getById(id);
        if(cityDescription==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityDescription,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDescription> deleteCityDescription(@PathVariable("id") Long id ){
        if(id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cityDescriptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDescription> saveCityDescription(@RequestBody @Valid CityDescription cityDescription){
        if(cityDescription==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cityDescriptionService.save(cityDescription);
        return new ResponseEntity<>(cityDescription,HttpStatus.OK);
    }

    @RequestMapping(value="",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDescription> updateCityDescription(@RequestBody @Valid CityDescription cityDescription){
        if(cityDescription==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cityDescriptionService.save(cityDescription);
        return new ResponseEntity<>(cityDescription,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDescription>> getAllDescriptions(){
        List<CityDescription> cityDescriptionListList =  cityDescriptionService.getAll();
        if(cityDescriptionListList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityDescriptionListList, HttpStatus.OK);
    }
}
