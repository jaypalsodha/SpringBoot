package com.learn.spring.firstspringbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.spring.firstspringbootproject.model.City;
import com.learn.spring.firstspringbootproject.service.ICityService;

@Controller
public class CityController {

    @Autowired
    private ICityService cityService;

    @RequestMapping(value="/showCities", method=RequestMethod.GET)
    public String findCities(ModelMap model) {
    	List<City> cities= (List<City>) cityService.findAll();
        model.addAttribute("cities", cities);
        return "showCities";
    }
}
