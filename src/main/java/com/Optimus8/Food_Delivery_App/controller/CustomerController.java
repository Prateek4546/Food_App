package com.Optimus8.Food_Delivery_App.controller;

import com.Optimus8.Food_Delivery_App.dto.reponse.CustomerResponse;
import com.Optimus8.Food_Delivery_App.dto.request.CustomerRequest;
import com.Optimus8.Food_Delivery_App.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse , HttpStatus.CREATED);
    }

    @GetMapping("/find/mobile/{mobile}")
    public  ResponseEntity getCustomerByMobileNo(@PathVariable("mobile") String mobile){
       try{
           CustomerResponse customerResponse = customerService.findCustomerByMobileNo(mobile);
           return new ResponseEntity(customerResponse , HttpStatus.FOUND);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
       }
    }
}
