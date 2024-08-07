package com.geo.api_gerenciamento_ecommerce.model;

import jakarta.persistence.*;
import org.hibernate.query.Order;

import java.util.Set;
@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private ProfileModel profile;

    @OneToMany(mappedBy = "customerModel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderModel>  OrderList;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }

    public Set<OrderModel> getOrderList() {
        return OrderList;
    }

    public void setOrderList(Set<OrderModel> orderList) {
        OrderList = orderList;
    }
}
