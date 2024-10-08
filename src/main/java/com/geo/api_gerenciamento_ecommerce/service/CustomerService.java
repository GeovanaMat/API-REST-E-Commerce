package com.geo.api_gerenciamento_ecommerce.service;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public CustomerModel creatCustomer(CustomerDto customerDto);
    public CustomerModel getCustomerById(Long id);
    public List<CustomerModel> getAllCustomers();
    public CustomerModel updateCustomerById(Long id, CustomerDto customerDto);
    public void deleteCustomerById(Long id);
}
