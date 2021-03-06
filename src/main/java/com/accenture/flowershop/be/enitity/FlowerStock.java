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

    @OneToOne
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
