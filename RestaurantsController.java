package com.tcs.swiggy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.swiggy.model.Restaurants;
import com.tcs.swiggy.service.RestaurantService;

@RestController
@RequestMapping("/rest/restaurants")
public class RestaurantsController {

    @Autowired
    RestaurantService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveRestaurants(@RequestBody Restaurants request) {
        service.save(request);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        return ResponseEntity.ok(service.getAllRestaurants());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Restaurants>> getRestaurantName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteRestaurantByName(@PathVariable String name) {
        service.deleteByName(name);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PostMapping("/saveBulk")
    public ResponseEntity<String> saveBulkRestaurants(@RequestBody List<Restaurants> requests) {
        service.saveAll(requests);
        return ResponseEntity.ok("Bulk Restaurants Saved Successfully");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllRestaurants() {
        service.deleteAll();
        return ResponseEntity.ok("All Restaurants Deleted Successfully");
    }
}
