package com.Optimus8.Food_Delivery_App.model;

import com.Optimus8.Food_Delivery_App.Enums.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "fooditem")
public class Fooditem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String dishName;
     double prices;

     @Enumerated(EnumType.STRING)
    FoodCategory category;
    boolean veg;
    boolean available;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @ManyToOne
    @JoinColumn
    OrderEntity order;

    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
}
