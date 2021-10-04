package com.example.market.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales_details")
public class DbSaleDetail {
    @EmbeddedId
    private DbSaleDetailPK id;

    private Integer quantity;
    private Double total;
    private Boolean active;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private DbSale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private DbProduct product;

    public DbSaleDetailPK getId() {
        return id;
    }

    public void setId(DbSaleDetailPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DbSale getSale() {
        return sale;
    }

    public void setSale(DbSale sale) {
        this.sale = sale;
    }

    public DbProduct getProduct() {
        return product;
    }

    public void setProduct(DbProduct product) {
        this.product = product;
    }
}
