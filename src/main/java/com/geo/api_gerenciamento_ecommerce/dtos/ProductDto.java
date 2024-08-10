package com.geo.api_gerenciamento_ecommerce.dtos;

import com.geo.api_gerenciamento_ecommerce.model.CategoryModel;

import java.util.Set;

public record ProductDto(String nome,
                         String description,
                         Double price,
                         String category) {
}

