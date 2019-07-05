package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerStockDao;
import com.accenture.flowershop.be.enitity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowerStockServiceImpl implements FlowerStockService{

    @Autowired
    private FlowerStockDao flowerStockDao;

    @Override
    public long getCountById(long id) {
         return flowerStockDao.getCountById(id);
    }
}
