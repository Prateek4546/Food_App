package com.Optimus8.Food_Delivery_App.exception;

public class RestaurantNotFoundException extends RuntimeException{
    public  RestaurantNotFoundException(String message){
        super(message);
    }
}
