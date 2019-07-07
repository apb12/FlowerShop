package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.enitity.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> findAll();

    Flower findById(long id);
}
