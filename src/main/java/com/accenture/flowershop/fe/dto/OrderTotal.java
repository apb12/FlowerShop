package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderTotal {
    private long id;
    private User user;
    private List<Order> orderList;
    private BigDecimal totalPrice;
    private BigDecimal finalPrice;
    private Date startOrder;
    private Date closeOrder;
    private OrderStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(Date startOrder) {
        this.startOrder = startOrder;
    }

    public Date getCloseOrder() {
        return closeOrder;
    }

    public void setCloseOrder(Date closeOrder) {
        this.closeOrder = closeOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }




    public OrderTotal(long id, User user, List<Order> orderList, BigDecimal totalPrice, BigDecimal finalPrice, Date startOrder, Date closeOrder, OrderStatus status) {
        this.id = id;
        this.user = user;
        this.orderList = orderList;
        this.totalPrice = totalPrice;
        this.finalPrice = finalPrice;
        this.startOrder = startOrder;
        this.closeOrder = closeOrder;
        this.status = status;
    }
}
