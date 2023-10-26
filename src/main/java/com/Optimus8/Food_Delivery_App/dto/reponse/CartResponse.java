package com.Optimus8.Food_Delivery_App.dto.reponse;

import com.Optimus8.Food_Delivery_App.model.Fooditem;

import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {

    int cartTotal;

    List<FoodResponse> fooditems;
}
