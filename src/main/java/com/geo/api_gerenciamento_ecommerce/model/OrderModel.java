package com.geo.api_gerenciamento_ecommerce.model;

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
    private CustomerModel customerModel;

    @OneToMany(mappedBy = "orderModel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderItemModel> orderItemModelSet;

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

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public Set<OrderItemModel> getOrderItemModelSet() {
        return orderItemModelSet;
    }

    public void setOrderItemModelSet(Set<OrderItemModel> orderItemModelSet) {
        this.orderItemModelSet = orderItemModelSet;
    }
}
