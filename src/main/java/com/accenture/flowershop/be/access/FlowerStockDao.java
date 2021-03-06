package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.FlowerStock;

import java.util.List;

public interface FlowerStockDao {

    List<FlowerStock> findAll();
    void updateFlowerStock(long id,long count);
    FlowerStock findFlowerStockById(long id);
}
