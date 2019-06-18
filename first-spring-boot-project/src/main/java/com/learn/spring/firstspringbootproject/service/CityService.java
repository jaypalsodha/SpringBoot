package com.learn.spring.firstspringbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.firstspringbootproject.model.City;
import com.learn.spring.firstspringbootproject.repository.CityRepository;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        return (List<City>) repository.findAll();
    }
}