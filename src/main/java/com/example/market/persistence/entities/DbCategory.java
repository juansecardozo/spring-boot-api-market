package com.example.market.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class DbCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private Boolean active;

    @OneToMany(mappedBy = "category")
    private List<DbProduct> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<DbProduct> getProducts() {
        return products;
    }

    public void setProducts(List<DbProduct> products) {
        this.products = products;
    }
}
