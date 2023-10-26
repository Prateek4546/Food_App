package com.Optimus8.Food_Delivery_App.dto.reponse;

import com.Optimus8.Food_Delivery_App.Enums.FoodCategory;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodResponse {
    String dishName;
    double prices;
    FoodCategory category;
    boolean veg;

}
