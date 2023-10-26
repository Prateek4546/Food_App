package com.Optimus8.Food_Delivery_App.services;

import com.Optimus8.Food_Delivery_App.dto.reponse.CustomerResponse;
import com.Optimus8.Food_Delivery_App.dto.request.CustomerRequest;
import com.Optimus8.Food_Delivery_App.exception.CustomerNotFoundException;
import com.Optimus8.Food_Delivery_App.model.Cart;
import com.Optimus8.Food_Delivery_App.model.Customer;
import com.Optimus8.Food_Delivery_App.repository.CustomerRepository;
import com.Optimus8.Food_Delivery_App.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // dto to customer Model
        Customer customer = CustomerTransformer.CustomerRequestTOCustomer(customerRequest);
        // allocate the card
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                   .build();

        customer.setCart(cart);
        // save customer and cart
        Customer saveCustomer = customerRepository.save(customer);

        // prepare response dto
        return CustomerTransformer.CustomerToCustomerResponse(saveCustomer);
    }

    public CustomerResponse findCustomerByMobileNo(String mobile) {
        Customer customer = customerRepository.findByMobileNo(mobile);
        if(customer == null){
            throw new CustomerNotFoundException("Invalid Mobile No");
        }
        else{
            return CustomerTransformer.CustomerToCustomerResponse(customer);
        }
    }
}
