package com.Optimus8.Food_Delivery_App.repository;

import com.Optimus8.Food_Delivery_App.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
       public  Customer findByMobileNo(String moblie);
}
