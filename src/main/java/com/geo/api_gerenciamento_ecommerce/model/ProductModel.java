package com.geo.api_gerenciamento_ecommerce.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private CategoryModel category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderItemModel> orderItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public Set<OrderItemModel> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItemModel> orderItem) {
        this.orderItem = orderItem;
    }
}
