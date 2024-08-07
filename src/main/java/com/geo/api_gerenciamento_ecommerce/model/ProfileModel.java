package com.geo.api_gerenciamento_ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROFILE")
public class ProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adress;
    private String phone;

    @OneToOne(mappedBy = "profile",fetch = FetchType.LAZY)
    private CustomerModel customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
