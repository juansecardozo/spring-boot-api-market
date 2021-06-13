package com.example.market.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class DbSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "payment_type")
    private String paymentType;

    private LocalDateTime date;
    private String comments;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private DbCustomer customer;

    @OneToMany(mappedBy = "sale")
    private List<DbSaleDetail> details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DbCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DbCustomer customer) {
        this.customer = customer;
    }

    public List<DbSaleDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DbSaleDetail> details) {
        this.details = details;
    }
}
