package com.Optimus8.Food_Delivery_App.controller;

import com.Optimus8.Food_Delivery_App.dto.reponse.RestaurantResponse;
import com.Optimus8.Food_Delivery_App.dto.request.RestaurantRequest;
import com.Optimus8.Food_Delivery_App.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    final RestaurantService restaurantService;
    @Autowired
    public  RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }
    @PostMapping("/add")
    public ResponseEntity addRestaurnt(@RequestBody RestaurantRequest restaurantRequest){
       RestaurantResponse response =  restaurantService.addRestaurant(restaurantRequest);
       return new ResponseEntity(response , HttpStatus.CREATED);
    }

}
