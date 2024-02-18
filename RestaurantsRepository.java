package com.tcs.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.swiggy.model.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

    List<Restaurants> findByRestaurantName(String name);

    List<Restaurants> deleteByRestaurantName(String name);

    void deleteAll();
}
