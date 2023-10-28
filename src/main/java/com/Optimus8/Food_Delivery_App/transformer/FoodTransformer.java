package com.Optimus8.Food_Delivery_App.transformer;

import com.Optimus8.Food_Delivery_App.dto.reponse.FoodResponse;
import com.Optimus8.Food_Delivery_App.model.Fooditem;

public class FoodTransformer {

    public static FoodResponse FooditemToFoodResponse(Fooditem fooditem){
        return FoodResponse.builder()
                .dishName(fooditem.getDishName())
                .prices(fooditem.getPrices())
                .veg(fooditem.isVeg())
                .category(fooditem.getCategory())
                .build();
    }
}
