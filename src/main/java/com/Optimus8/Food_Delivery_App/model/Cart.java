package com.Optimus8.Food_Delivery_App.model;

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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int cartTotal;


    @OneToOne
    @JoinColumn
    Customer customer;
    @OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL)
    List<Fooditem> fooditems = new ArrayList<>();
}
