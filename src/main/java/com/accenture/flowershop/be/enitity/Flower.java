package com.accenture.flowershop.be.enitity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Flower implements Serializable {

    public Flower(){}



    @Id
    private long id;
    private String name;
    private BigDecimal price;

    public Flower(long id,String name, BigDecimal price) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
