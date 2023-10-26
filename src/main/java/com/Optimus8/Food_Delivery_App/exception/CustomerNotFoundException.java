package com.Optimus8.Food_Delivery_App.exception;

public class CustomerNotFoundException extends RuntimeException{
    public  CustomerNotFoundException(String message){
        super(message);
    }
}
