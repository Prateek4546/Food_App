package com.Optimus8.Food_Delivery_App.transformer;

import com.Optimus8.Food_Delivery_App.dto.reponse.CartResponse;
import com.Optimus8.Food_Delivery_App.model.Cart;

import java.util.ArrayList;

public class CartTransformer {

    public static CartResponse CartToCartResponse(Cart cart){
           return  CartResponse.builder()
                   .cartTotal(cart.getCartTotal())
                   .fooditems(new ArrayList<>())
                   .build();
    }
}
