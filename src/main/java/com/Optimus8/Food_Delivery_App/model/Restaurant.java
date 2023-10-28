package com.Optimus8.Food_Delivery_App.model;

import com.Optimus8.Food_Delivery_App.Enums.RestaurantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Enumerated(EnumType.STRING)
    RestaurantCategory restaurantCategory;

    @Column(unique = true , nullable = false)
    @Size(min = 10 , max = 10)
    String contactNumber;

    boolean open;

    @OneToMany(mappedBy = "restaurant" , cascade =  CascadeType.ALL)
    List<Fooditem> availableFoodItems = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

}
