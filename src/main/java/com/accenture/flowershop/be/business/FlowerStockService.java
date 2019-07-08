package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.FlowerStock;

import java.util.List;

public interface FlowerStockService {

    List<FlowerStock>findAll();
}
