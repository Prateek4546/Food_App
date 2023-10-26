package com.Optimus8.Food_Delivery_App.transformer;

import com.Optimus8.Food_Delivery_App.dto.reponse.CartResponse;
import com.Optimus8.Food_Delivery_App.dto.reponse.CustomerResponse;
import com.Optimus8.Food_Delivery_App.dto.request.CustomerRequest;
import com.Optimus8.Food_Delivery_App.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestTOCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .adderss(customerRequest.getAdderss())
                .mobileNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        CartResponse cartResponse = CartTransformer.CartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .address(customer.getAdderss())
                .mobileNo(customer.getMobileNo())
                .cart(cartResponse)
                .build();
    }
}
