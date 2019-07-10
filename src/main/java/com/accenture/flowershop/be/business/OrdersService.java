package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

public interface OrdersService {
    boolean createOrder(long user_id, Date order_date);
}
