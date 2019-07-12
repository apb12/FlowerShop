package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    @Transactional
    public boolean createOrder(long user_id,Date order_date) {
        return ordersDao.createOrder(user_id,order_date);
    }
}
