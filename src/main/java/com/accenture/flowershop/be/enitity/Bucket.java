package com.accenture.flowershop.be.enitity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bucket {
    public Bucket() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUCKET_SEQ")
    @SequenceGenerator(name = "BUCKET_SEQ", sequenceName = "BUCKET_SEQ", allocationSize = 1)
    private long id;
    private long orders_id;
    private long amount;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(long order_id) {
        this.orders_id = order_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
