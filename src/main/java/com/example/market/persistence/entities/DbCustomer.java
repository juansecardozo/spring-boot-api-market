package com.example.market.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class DbCustomer {
    @Id
    private String id;

    @Column(name = "mobile_number")
    private Integer mobileNumber;

    private String name;
    private String surname;
    private String address;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<DbSale> sales;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DbSale> getSales() {
        return sales;
    }

    public void setSales(List<DbSale> sales) {
        this.sales = sales;
    }
}
