package com.learn.spring.firstspringbootproject.service;

import java.util.List;

import com.learn.spring.firstspringbootproject.model.City;

public interface ICityService {

    List<City> findAll();
}
