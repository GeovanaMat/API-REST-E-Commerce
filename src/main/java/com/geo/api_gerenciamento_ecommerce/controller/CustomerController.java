package com.geo.api_gerenciamento_ecommerce.controller;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer( @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.creatCustomer(customerDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CustomerModel> returnOneCustomerById(@PathVariable(value = "id") Long id){
        return  new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<CustomerModel>> returnAllCustomer(){
        return  new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> updateCustomerById(@PathVariable(value = "id") Long id, @RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.updateCustomerById(id,customerDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>("Customer deleted sucessfuly",HttpStatus.OK);
    }

}
