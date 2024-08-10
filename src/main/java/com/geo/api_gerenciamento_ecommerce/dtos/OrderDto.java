package com.geo.api_gerenciamento_ecommerce.dtos;

import com.geo.api_gerenciamento_ecommerce.model.OrderItemModel;

import java.util.Set;

public record OrderDto (Long customerId,
                        Set<OrderItemDto> orderItems){
}
