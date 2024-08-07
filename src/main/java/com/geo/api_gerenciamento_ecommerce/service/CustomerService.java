package com.geo.api_gerenciamento_ecommerce.service;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public CustomerModel creatCustomer(CustomerDto customerDto);
    public CustomerModel getCustomerById(Long id);
    public CustomerModel updateCustomerById(Long id, CustomerDto customerDto);
    public CustomerModel deleteCustomerById(Long id, CustomerDto customerDto);
}
