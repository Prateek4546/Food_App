package com.Optimus8.Food_Delivery_App.model;
import com.Optimus8.Food_Delivery_App.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
