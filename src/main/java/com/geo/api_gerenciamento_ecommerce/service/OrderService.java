package com.geo.api_gerenciamento_ecommerce.service;

import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public OrderModel createOrder(OrderDto orderDto);
    public OrderModel getOrderById(Long id);
    public List<OrderModel> getAllOrders();
    public OrderModel updateOrderById(Long id, OrderDto orderDto);
    public void deleteOrderById(Long id);
}
