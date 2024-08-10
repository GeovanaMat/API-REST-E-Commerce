package com.geo.api_gerenciamento_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<OrderItemModel> orderItem;

    public ProductModel(){
        this.orderItem = new HashSet<>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderItemModel> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItemModel> orderItem) {
        this.orderItem = orderItem;
    }

    public void addOrdemItem(OrderItemModel orderItemModel){
        this.orderItem.add(orderItemModel);
    }

    public void addOrderItem(OrderItemModel orderItem) {
        this.orderItem.add(orderItem);
    }
}
