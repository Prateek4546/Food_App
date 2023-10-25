package com.Optimus8.Food_Delivery_App.model;

import com.Optimus8.Food_Delivery_App.Enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Size(min = 2 ,message = "{validation.name.size.too_short}")
    @Size(min = 40 ,message = "{validation.name.size.too_long}")
    String name;

    @Email
    @Column(unique = true)
    String email;

    String adderss;

    @Column(unique = true , nullable = false)
    @Size(max = 10 , min = 10)
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer" , cascade =  CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
