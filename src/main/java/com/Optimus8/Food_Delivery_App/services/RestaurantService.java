package com.Optimus8.Food_Delivery_App.services;

import com.Optimus8.Food_Delivery_App.dto.reponse.RestaurantResponse;
import com.Optimus8.Food_Delivery_App.dto.request.RestaurantRequest;
import com.Optimus8.Food_Delivery_App.model.Restaurant;
import com.Optimus8.Food_Delivery_App.repository.RestaurantRepository;
import com.Optimus8.Food_Delivery_App.transformer.FoodTransformer;
import com.Optimus8.Food_Delivery_App.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    final RestaurantRepository restaurantRepository;
    @Autowired
    public  RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // Dto to model

        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
     // Save  the model in to DB
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
     // model to dto
        return RestaurantTransformer.RestaurantToRestaurantResponse(saveRestaurant);
    }
}
