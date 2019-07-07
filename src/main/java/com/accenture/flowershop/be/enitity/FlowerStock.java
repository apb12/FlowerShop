package com.accenture.flowershop.be.enitity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FlowerStock implements Serializable {

    public FlowerStock() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLOWERSTOCK_SEQ")
    @SequenceGenerator(name = "FLOWERSTOCK_SEQ", sequenceName = "FLOWERSTOCK_SEQ", allocationSize = 1)
    private long id;
    private long count;
    @OneToOne(mappedBy = "flowerStock")
    private Flower flower;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }
}
