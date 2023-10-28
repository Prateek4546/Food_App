package com.Optimus8.Food_Delivery_App.transformer;

import com.Optimus8.Food_Delivery_App.dto.reponse.FoodResponse;
import com.Optimus8.Food_Delivery_App.dto.request.FoodRequest;
import com.Optimus8.Food_Delivery_App.model.Fooditem;

public class FoodTransformer {

    public static Fooditem FoodRequestToFood(FoodRequest foodRequest){
        return Fooditem.builder()
                .dishName(foodRequest.getDishName())
                .category(foodRequest.getCategory())
                .prices(foodRequest.getPrices())
                .veg(foodRequest.isVeg())
                .available(foodRequest.isAvailable())
                .build();
    }

    public static FoodResponse FooditemToFoodResponse(Fooditem fooditem){
        return FoodResponse.builder()
                .dishName(fooditem.getDishName())
                .prices(fooditem.getPrices())
                .veg(fooditem.isVeg())
                .category(fooditem.getCategory())
                .build();
    }
}
