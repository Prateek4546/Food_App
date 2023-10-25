package com.Optimus8.Food_Delivery_App.model;

import com.Optimus8.Food_Delivery_App.Enums.RestaurantCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String location;
    RestaurantCategory restaurantCategory;
    String contactNumber;
    boolean open;

    @OneToMany(mappedBy = "restaurant" , cascade =  CascadeType.ALL)
    List<Fooditem> availableFoodItems = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

}
