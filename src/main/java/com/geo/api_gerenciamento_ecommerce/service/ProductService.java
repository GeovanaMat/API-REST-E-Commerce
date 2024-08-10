package com.geo.api_gerenciamento_ecommerce.service;

import com.geo.api_gerenciamento_ecommerce.dtos.ProductDto;
import com.geo.api_gerenciamento_ecommerce.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ProductModel creatProduct(ProductDto productDto);
    public ProductModel getProductById(Long id);
    public List<ProductModel> getAllProducts();
    public ProductModel updateProductById(Long id, ProductDto productDto);
    public void deleteProductById(Long id);
}
