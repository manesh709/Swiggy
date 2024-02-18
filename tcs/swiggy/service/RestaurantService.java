package com.tcs.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.swiggy.model.Restaurants;
import com.tcs.swiggy.repository.RestaurantsRepository;

@Service
public class RestaurantService {

    @Autowired
    RestaurantsRepository restaurantsRepository;

    public void save(Restaurants request) {
        restaurantsRepository.save(request);
    }

    public List<Restaurants> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }

    public List<Restaurants> getByName(String name) {
        return restaurantsRepository.findByRestaurantName(name);
    }

    @Transactional
    public void deleteByName(String name) {
        restaurantsRepository.deleteByRestaurantName(name);
    }

    public void saveAll(List<Restaurants> requests) {
        restaurantsRepository.saveAll(requests);
    }

    public void deleteAll() {
        restaurantsRepository.deleteAll();
    }
}
