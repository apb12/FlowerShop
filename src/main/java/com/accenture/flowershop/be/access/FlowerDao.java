package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Flower;

import java.util.List;

public interface FlowerDao {
    Flower findById(long id);

    List<Flower> findAll();

    void removeFlower(long id);

    List<Flower> sortAsc();

    List<Flower> sortDesc();
}
