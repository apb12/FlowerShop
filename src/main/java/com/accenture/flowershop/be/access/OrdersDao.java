package com.accenture.flowershop.be.access;

import java.util.Date;

public interface OrdersDao {
    boolean createOrder(long user_id, Date order_date);
}
