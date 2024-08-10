package com.geo.api_gerenciamento_ecommerce.service.Impl;

import ch.qos.logback.core.net.server.Client;
import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceNotFoundException;
import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import com.geo.api_gerenciamento_ecommerce.repository.CustomerRepository;
import com.geo.api_gerenciamento_ecommerce.repository.OrderItemRepository;
import com.geo.api_gerenciamento_ecommerce.repository.OrderRepository;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import com.geo.api_gerenciamento_ecommerce.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    private OrderItemRepository orderItemRepository;


    @Override
    public OrderModel creatOrder(OrderDto orderDto) {
        var newOrder = new OrderModel(orderDto);
        var customer = customerRepository.findById(orderDto.customerId());
        if(customer.isPresent()){
            var customerObj =  customer.get();
            newOrder.setCustomer(customerObj);
            orderRepository.save(newOrder);
            customerObj.addOrder(newOrder);
            customerRepository.save(customerObj);
            return newOrder;
        }
        throw new ResourceNotFoundException("Customer not found.");
    }

    @Override
    public OrderModel getOrderById(Long id) {
        var orderDataBase = orderRepository.findById(id);
        if(orderDataBase.isPresent()) {
            return orderDataBase.get();
        }
        throw new IllegalArgumentException("Order not found.");
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel updateOrderById(Long id, OrderDto orderDto) {
        var orderDataBase = getOrderById(id);
        BeanUtils.copyProperties(orderDto,orderDataBase);
        orderRepository.save(orderDataBase);
        return orderDataBase;
    }

    @Override
    public void deleteOrderById(Long id) {
        var orderDatabase = getOrderById(id);
        orderRepository.delete(orderDatabase);
    }
}
