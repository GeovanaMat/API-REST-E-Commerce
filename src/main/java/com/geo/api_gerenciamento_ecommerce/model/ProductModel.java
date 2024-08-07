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
    private String descricao;
    private Double price;

    @Enumerated(EnumType.STRING)
    private CategoryModel categoryModel;

    @OneToMany(mappedBy = "productModel",fetch = FetchType.LAZY)
    private Set<OrderItemModel> orderItemModel;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public Set<OrderItemModel> getOrderItemModel() {
        return orderItemModel;
    }

    public void setOrderItemModel(Set<OrderItemModel> orderItemModel) {
        this.orderItemModel = orderItemModel;
    }
}
