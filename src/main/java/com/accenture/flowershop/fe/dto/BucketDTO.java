package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.Orders;

import java.math.BigDecimal;

public class BucketDTO {
    private long id;
    private long amount;
    private BigDecimal price;
    private Flower flower;
    private Orders orders;

    public BucketDTO() {
    }

    public BucketDTO(long id, long amount, BigDecimal price, Flower flower, Orders orders) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.flower = flower;
        this.orders = orders;
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

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "BucketDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", flower=" + flower +
                ", orders=" + orders +
                '}';
    }
}
