package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.FlowerDao;
import com.accenture.flowershop.be.enitity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerDao flowerDao;

    @Override
    public List<Flower> findAll() {
        return flowerDao.findAll();
    }
}
