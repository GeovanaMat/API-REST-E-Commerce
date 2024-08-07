package com.geo.api_gerenciamento_ecommerce.controller;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer( @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.creatCustomer(customerDto),HttpStatus.CREATED);
    }
}
