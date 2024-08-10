package com.geo.api_gerenciamento_ecommerce.repository;

import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.model.ProductModel;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel,Long> {

    public Optional<ProductModel> findByName(String name);
}
