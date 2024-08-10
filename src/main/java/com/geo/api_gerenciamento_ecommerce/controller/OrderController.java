package com.geo.api_gerenciamento_ecommerce.controller;

import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import com.geo.api_gerenciamento_ecommerce.model.OrderModel;
import com.geo.api_gerenciamento_ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
        @Autowired
        private OrderService orderService;

        @PostMapping
        public ResponseEntity<OrderModel> createOrder(@RequestBody OrderDto orderDto) {
            return new ResponseEntity<>(orderService.creatOrder(orderDto), HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public  ResponseEntity<OrderModel> returnOneOrderById(@PathVariable(value = "id") Long id){
            return  new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
        }

        @GetMapping
        public  ResponseEntity<List<OrderModel>> returnAllOrder(){
            return  new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<OrderModel> updateOrderById(@PathVariable(value = "id") Long id, @RequestBody OrderDto orderDto){
            return new ResponseEntity<>(orderService.updateOrderById(id,orderDto),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCustomById(@PathVariable(value = "id") Long id){
            return new ResponseEntity<>("Order deleted sucessfuly",HttpStatus.OK);
        }

    }


