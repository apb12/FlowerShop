package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.enitity.FlowerStock;

import java.math.BigDecimal;

public class FlowerDTO {
    private long id;
    private String name;
    private BigDecimal price;
    private FlowerStock flowerStock;

    public FlowerDTO() {
    }

    public FlowerDTO(long id, String name, BigDecimal price, FlowerStock flowerStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flowerStock = flowerStock;
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

    public FlowerStock getFlowerStock() {
        return flowerStock;
    }

    public void setFlowerStock(FlowerStock flowerStock) {
        this.flowerStock = flowerStock;
    }

    @Override
    public String toString() {
        return "FlowerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", flowerStock=" + flowerStock +
                '}';
    }
}
