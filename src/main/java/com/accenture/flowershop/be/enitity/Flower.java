package com.accenture.flowershop.be.enitity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Flower implements Serializable {

    public Flower() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLOWER_SEQ")
    @SequenceGenerator(name = "FLOWER_SEQ", sequenceName = "FLOWER_SEQ", allocationSize = 1)
    private long id;
    private String name;
    private BigDecimal price;

    @OneToOne(mappedBy = "flower")
    private FlowerStock flowerStock;

    public long getId() {
        return id;
    }

    public void setId(long idflower) {
        this.id = idflower;
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
}
