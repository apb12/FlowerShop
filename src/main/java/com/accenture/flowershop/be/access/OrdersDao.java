package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrdersDao {
    boolean createOrder(long user_id, Date order_date);

    Orders findOrdersById(long id);

    void updateOrders(long id, BigDecimal price, OrderStatus orderStatus);

    void updateOrders(long id, OrderStatus orderStatus);

    List<Orders> findOrderByStatus(OrderStatus status);

    List<Orders> findOrderByUser(long id);

    void ordersDelete(long id);
}
