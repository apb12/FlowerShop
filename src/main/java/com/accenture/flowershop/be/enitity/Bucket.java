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
    private long amount;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

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
