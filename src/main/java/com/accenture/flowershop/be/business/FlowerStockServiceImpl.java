package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerStockDao;
import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerStockServiceImpl implements FlowerStockService{

    @Autowired
    private FlowerStockDao flowerStockDao;



    @Override
    public List<FlowerStock> findAll() {
        return flowerStockDao.findAll();
    }
}
