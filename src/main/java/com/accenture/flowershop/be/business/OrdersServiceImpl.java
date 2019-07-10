package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public boolean createOrder(long user_id,Date order_date) {
        return ordersDao.createOrder(user_id,order_date);
    }
}
