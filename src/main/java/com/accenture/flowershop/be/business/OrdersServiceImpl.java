package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.OrdersDao;
import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
   // @Transactional
    public boolean createOrder(long user_id,Date order_date) {
        return ordersDao.createOrder(user_id,order_date);
    }

    @Override
    public Orders findOrdersById(long id) {
        return ordersDao.findOrdersById(id);
    }

    @Override
    public void updateOrders(long id, BigDecimal price, OrderStatus orderStatus) {
        ordersDao.updateOrders(id,price,orderStatus);

    }

    @Override
    public void updateOrders(long id, OrderStatus orderStatus) {
        ordersDao.updateOrders(id,orderStatus);

    }

    @Override
    public List<Orders> findOrderByStatus(OrderStatus status) {
        return ordersDao.findOrderByStatus(status);
    }

    @Override
    public void ordersDelete(long id) {
        ordersDao.ordersDelete(id);
    }

    @Override
    public List<Orders> findOrderByUser(long id) {
        return ordersDao.findOrderByUser(id);
    }
}
