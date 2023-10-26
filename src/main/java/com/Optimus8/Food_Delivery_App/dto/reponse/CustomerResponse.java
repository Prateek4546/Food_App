package com.Optimus8.Food_Delivery_App.dto.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    String name;

    String mobileNo;

    String address;
    CartResponse cart;


}
