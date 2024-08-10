package com.geo.api_gerenciamento_ecommerce.service.Impl;

import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceNotFoundException;
import com.geo.api_gerenciamento_ecommerce.model.OrderItemModel;
import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import com.geo.api_gerenciamento_ecommerce.repository.CustomerRepository;
import com.geo.api_gerenciamento_ecommerce.repository.OrderItemRepository;
import com.geo.api_gerenciamento_ecommerce.repository.OrderRepository;
import com.geo.api_gerenciamento_ecommerce.repository.ProductRepository;
import com.geo.api_gerenciamento_ecommerce.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository,
                        OrderItemRepository orderItemRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    /**
     * Creates a new order based on the provided OrderDto.
     *
     * @param orderDto the data transfer object containing order details
     * @return the created OrderModel
     * @throws ResourceNotFoundException if any customer or product specified in the order does not exist
     */
    @Override
    public OrderModel createOrder(OrderDto orderDto) {

        // Retrieve the customer from the database
        var customer = customerRepository.findById(orderDto.customerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer id: " + orderDto.customerId() + " not found."));

        // Create a new order and associate it with the customer
        var newOrder = new OrderModel();
        customer.addOrder(newOrder);
        orderRepository.save(newOrder);

        // Set the customer reference in the order
        newOrder.setCustomer(customer);

        // Process each order item
        for (var item : orderDto.orderItems()) {
            var product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product id: " + item.productId() + " not found."));

            var orderItem = new OrderItemModel();
            orderItem.setQuantity(item.quantity());
            orderItem.setOrder(newOrder);
            orderItem.setProduct(product);

            // Add the order item to both the order and the product
            newOrder.addOrderItem(orderItem);
            product.addOrderItem(orderItem);

            // Save the order item and the updated product
            orderItemRepository.save(orderItem);
            productRepository.save(product);
        }

        // Save the updated customer with the new order
        customerRepository.save(customer);

        return newOrder;
    }



    @Override
    public OrderModel getOrderById(Long id) {
        var orderDataBase = orderRepository.findById(id);
        if(orderDataBase.isPresent()) {
            return orderDataBase.get();
        }
        throw new ResourceNotFoundException("Order not found.");
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
