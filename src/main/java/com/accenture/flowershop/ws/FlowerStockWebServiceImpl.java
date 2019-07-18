package com.accenture.flowershop.ws;

import com.accenture.flowershop.be.business.FlowerStockService;
import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(endpointInterface = "com.accenture.flowershop.ws.FlowerStockWebService")
public class FlowerStockWebServiceImpl implements FlowerStockWebService {

    @Autowired
    private FlowerStockService flowerStockService;


    public void increaseFlowerStockSize(long count) {
        for (FlowerStock f:flowerStockService.findAll()){
            flowerStockService.updateFlowerStock(f.getId(),(f.getCount()+count));
        }

    }
}