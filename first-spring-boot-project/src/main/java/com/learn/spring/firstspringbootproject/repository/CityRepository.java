package com.learn.spring.firstspringbootproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.spring.firstspringbootproject.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
