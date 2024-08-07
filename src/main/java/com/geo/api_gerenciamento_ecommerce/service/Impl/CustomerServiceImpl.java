package com.geo.api_gerenciamento_ecommerce.service.Impl;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerModel creatCustomer(CustomerDto customerDto) {
        System.out.println(customerDto);
        return null;
    }

    @Override
    public CustomerModel getCustomerById(Long id) {
        return null;
    }

    @Override
    public CustomerModel updateCustomerById(Long id, CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerModel deleteCustomerById(Long id, CustomerDto customerDto) {
        return null;
    }
}
