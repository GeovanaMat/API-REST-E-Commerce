package com.geo.api_gerenciamento_ecommerce.controller;

import com.geo.api_gerenciamento_ecommerce.dtos.ProductDto;
import com.geo.api_gerenciamento_ecommerce.model.ProductModel;
import com.geo.api_gerenciamento_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> createProduct( @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.creatProduct(productDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProductModel> returnOneProductById(@PathVariable(value = "id") Long id){
        return  new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<ProductModel>> returnAllProduct(){
        return  new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProductById(@PathVariable(value = "id") Long id, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProductById(id,productDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>("Product deleted sucessfuly",HttpStatus.OK);
    }

}
