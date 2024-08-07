package com.geo.api_gerenciamento_ecommerce.repository;

import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<CustomerModel,Long> {
}
