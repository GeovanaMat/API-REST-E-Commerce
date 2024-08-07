package com.geo.api_gerenciamento_ecommerce.dtos;

import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import com.geo.api_gerenciamento_ecommerce.model.ProfileModel;

import java.util.Set;

public record CustomerDto(String nome,
                          String email) {
}
