package com.Optimus8.Food_Delivery_App.dto.request;

import com.Optimus8.Food_Delivery_App.Enums.RestaurantCategory;


import com.Optimus8.Food_Delivery_App.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantRequest {
    String name;

    String location;

    RestaurantCategory restaurantCategory;

    String contactNumber;
}
