package com.geo.api_gerenciamento_ecommerce.dtos;

public record OrderItemDto(Integer quantity,
                           Double unitPrice,
                           OrderDto orderDto,
                           ProductDto productDto) {
}
