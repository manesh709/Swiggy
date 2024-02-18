package com.tcs.swiggy.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurants {
    private String restaurantName;
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    @ElementCollection
    @CollectionTable(name = "food_items", joinColumns = @JoinColumn(name = "restaurant_id"))
    private List<FoodItems> foodItems;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FoodItems> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }

}
