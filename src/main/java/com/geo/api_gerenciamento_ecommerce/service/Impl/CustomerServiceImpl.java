package com.geo.api_gerenciamento_ecommerce.service.Impl;

import com.geo.api_gerenciamento_ecommerce.dtos.CustomerDto;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.repository.CustomerRepository;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerModel creatCustomer(CustomerDto customerDto) {
        var newCustomer = new CustomerModel();
        BeanUtils.copyProperties(customerDto,newCustomer);
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    @Override
    public CustomerModel getCustomerById(Long id) {
        var customerDataBase = customerRepository.findById(id);
        if(customerDataBase.isPresent()) {
            return customerDataBase.get();
        }
        throw new IllegalArgumentException("Customer not found.");
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel updateCustomerById(Long id, CustomerDto customerDto) {
        var customerDataBase = getCustomerById(id);
        BeanUtils.copyProperties(customerDto,customerDataBase);
        customerRepository.save(customerDataBase);
        return customerDataBase;
    }

    @Override
    public void deleteCustomerById(Long id) {
        var customerDatabase = getCustomerById(id);
        customerRepository.delete(customerDatabase);
    }
}
