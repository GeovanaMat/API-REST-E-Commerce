package com.geo.api_gerenciamento_ecommerce.repository;

import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel,Long> {
}
