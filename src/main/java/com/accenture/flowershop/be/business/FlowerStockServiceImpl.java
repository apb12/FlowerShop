package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerStockDao;
import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlowerStockServiceImpl implements FlowerStockService{

    @Autowired
    private FlowerStockDao flowerStockDao;



    @Override
    public List<FlowerStock> findAll() {
        return flowerStockDao.findAll();
    }

    @Override
    public FlowerStock findFlowerStockById(long id) {
        return flowerStockDao.findFlowerStockById(id);
    }

    @Override
    @Transactional
    public void updateFlowerStock(long id, long count) {
        flowerStockDao.updateFlowerStock(id,count);

    }
}
