package com.geo.api_gerenciamento_ecommerce.model;

import com.geo.api_gerenciamento_ecommerce.dtos.OrderDto;
import jakarta.persistence.*;
import org.hibernate.query.Order;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TB_ORDER")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderDate = LocalDate.now();
    private Double totalAmount;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderItemModel> orderItemList;

    public OrderModel(){}

    public OrderModel(OrderDto orderDto) {
        this.totalAmount = orderDto.totalAmount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public Set<OrderItemModel> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(Set<OrderItemModel> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
