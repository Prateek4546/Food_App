package com.Optimus8.Food_Delivery_App.repository;

import com.Optimus8.Food_Delivery_App.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
       public  Customer findByMobileNo(String moblie);
}
