package com.Optimus8.Food_Delivery_App.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "order_entity")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderId; // UUID
    int totalOrder;

    @CreationTimestamp
    Date orderTime;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    DeliveryPartner deliveryPartner;


    @OneToMany(mappedBy = "order" , cascade =  CascadeType.ALL)
    List<Fooditem> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Restaurant restaurant;
}
