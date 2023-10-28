package com.Optimus8.Food_Delivery_App.repository;

import com.Optimus8.Food_Delivery_App.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant , Integer> {
}
