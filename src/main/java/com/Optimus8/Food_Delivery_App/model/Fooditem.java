package com.Optimus8.Food_Delivery_App.model;

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
}
