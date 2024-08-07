package com.geo.api_gerenciamento_ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ORDERITEM")
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orderModel;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel productModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }
}
