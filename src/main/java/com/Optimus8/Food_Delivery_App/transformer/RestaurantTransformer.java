package com.Optimus8.Food_Delivery_App.transformer;

import com.Optimus8.Food_Delivery_App.dto.reponse.FoodResponse;
import com.Optimus8.Food_Delivery_App.dto.reponse.RestaurantResponse;
import com.Optimus8.Food_Delivery_App.dto.request.RestaurantRequest;
import com.Optimus8.Food_Delivery_App.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {

    public  static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest){
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .location(restaurantRequest.getLocation())
                .contactNumber(restaurantRequest.getContactNumber())
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .open(true)
                .availableFoodItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }
    public  static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant){
         List<FoodResponse> menu = restaurant.getAvailableFoodItems().stream()
                 .map(fooditem -> FoodTransformer.FooditemToFoodResponse(fooditem))
                 .collect(Collectors.toList());
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .contactNumber(restaurant.getContactNumber())
                .opened(restaurant.isOpen())
                .menu(menu)
                .build();
    }
}
