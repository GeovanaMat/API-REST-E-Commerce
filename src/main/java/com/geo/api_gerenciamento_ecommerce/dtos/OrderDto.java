package com.geo.api_gerenciamento_ecommerce.dtos;

import java.util.Set;

public record OrderDto (Double totalAmount,
                        Set<OrderItemDto> orderItemDtos){
}
