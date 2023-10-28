package com.Optimus8.Food_Delivery_App.dto.reponse;

import com.Optimus8.Food_Delivery_App.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponse {
    String name;
    String contactNumber;
    String location;
    boolean opened;
    List<FoodResponse> menu = new ArrayList<>();

}
