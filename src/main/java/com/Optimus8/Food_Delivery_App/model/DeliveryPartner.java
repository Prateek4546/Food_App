package com.Optimus8.Food_Delivery_App.model;
import com.Optimus8.Food_Delivery_App.Enums.Gender;
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
@Table(name = "delivery_partner")
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true , nullable = false)
    @Size(max = 10 , min = 10)
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "deliveryPartner" , cascade =  CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
