package com.geo.api_gerenciamento_ecommerce.service.Impl;

import com.geo.api_gerenciamento_ecommerce.dtos.ProductDto;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceAlreadyExistException;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceNotFoundException;
import com.geo.api_gerenciamento_ecommerce.model.Category;
import com.geo.api_gerenciamento_ecommerce.model.OrderItemModel;
import com.geo.api_gerenciamento_ecommerce.model.ProductModel;
import com.geo.api_gerenciamento_ecommerce.repository.OrderItemRepository;
import com.geo.api_gerenciamento_ecommerce.repository.ProductRepository;
import com.geo.api_gerenciamento_ecommerce.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates a new product based on the provided productDto.
     *
     * @param productDto the data transfer object containing product details
     * @return the created ProductModel
     * @throws ResourceNotFoundException if the category specified in the product does not match with predefined categories.
     * @throws ResourceAlreadyExistException if products already exist in database.
     */
    @Override
    public ProductModel creatProduct(ProductDto productDto) {
        if(productRepository.findByName(productDto.name()).isEmpty()){

            var newProduct = new ProductModel();
            BeanUtils.copyProperties(productDto,newProduct);
            newProduct.setCategory(Category.fromString(productDto.category()));

            if(newProduct.getCategory() != null){
                productRepository.save(newProduct);
                return newProduct;
            }
            throw new ResourceNotFoundException("Incorrect category or not found.");
        }
        throw new ResourceAlreadyExistException("Product already exist.");
    }

    @Override
    public ProductModel getProductById(Long id) {
        var productDataBase = productRepository.findById(id);
        if(productDataBase.isPresent()) {
            return productDataBase.get();
        }
        throw new ResourceNotFoundException("Product not found.");
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel updateProductById(Long id, ProductDto productDto) {
        var productDataBase = getProductById(id);
        BeanUtils.copyProperties(productDto,productDataBase);
        productRepository.save(productDataBase);
        return productDataBase;
    }

    @Override
    public void deleteProductById(Long id) {
        var productDatabase = getProductById(id);
        productRepository.delete(productDatabase);
    }

}
