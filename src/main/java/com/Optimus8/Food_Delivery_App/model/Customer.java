package com.Optimus8.Food_Delivery_App.model;

import com.Optimus8.Food_Delivery_App.Enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    String name;

    @Email
    @Column(unique = true)
    String email;

    String adderss;

    @Column(unique = true , nullable = false)
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
