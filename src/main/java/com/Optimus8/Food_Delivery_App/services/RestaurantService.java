package com.Optimus8.Food_Delivery_App.services;

import com.Optimus8.Food_Delivery_App.dto.reponse.RestaurantResponse;
import com.Optimus8.Food_Delivery_App.dto.request.FoodRequest;
import com.Optimus8.Food_Delivery_App.dto.request.RestaurantRequest;
import com.Optimus8.Food_Delivery_App.exception.RestaurantNotFoundException;
import com.Optimus8.Food_Delivery_App.model.Fooditem;
import com.Optimus8.Food_Delivery_App.model.Restaurant;
import com.Optimus8.Food_Delivery_App.repository.RestaurantRepository;
import com.Optimus8.Food_Delivery_App.transformer.FoodTransformer;
import com.Optimus8.Food_Delivery_App.transformer.RestaurantTransformer;
import com.Optimus8.Food_Delivery_App.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    final RestaurantRepository restaurantRepository;
    final ValidationUtils validationUtils;
    @Autowired
    public  RestaurantService(RestaurantRepository restaurantRepository, ValidationUtils validationUtils){
        this.restaurantRepository = restaurantRepository;
        this.validationUtils = validationUtils;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // Dto to model

        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
     // Save  the model in to DB
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
     // model to dto
        return RestaurantTransformer.RestaurantToRestaurantResponse(saveRestaurant);
    }

    public String changeOpenedStatus(int id) {

        // checking wether the restaurant id is valid or not
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty()){
            throw new RestaurantNotFoundException("Invalid Restaurant ID !!! ");
        }
          Restaurant restaurant = optionalRestaurant.get();
              restaurant.setOpen(!restaurant.isOpen());
              restaurantRepository.save(restaurant);
              if(restaurant.isOpen()){
                  return "Restaurant is  opened now!!!";
              }
              return "Restaurant is closed!!!";
    }

    public RestaurantResponse addFooditemToRestaurant(FoodRequest foodRequest) {
        // check Restaurant is valid or not
      //  Optional<Restaurant> restaurantOptinal = restaurantRepository.findById(foodRequest.getRestaurantId());
        if(!validationUtils.validateRestaurantId(foodRequest.getRestaurantId())){
            throw  new RestaurantNotFoundException("Invalid Restaurant id!!! ");
        }
        Restaurant restaurant = restaurantRepository.findById(foodRequest.getRestaurantId()).get();
        // dto to food
        Fooditem fooditem = FoodTransformer.FoodRequestToFood(foodRequest);
        fooditem.setRestaurant(restaurant);

        restaurant.getAvailableFoodItems().add(fooditem);

        // save food and restaurant
        Restaurant saverestaurant = restaurantRepository.save(restaurant);

        // prepare response
        return RestaurantTransformer.RestaurantToRestaurantResponse(saverestaurant);
    }
}
