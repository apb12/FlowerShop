package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private long id;
    private long user_id;
    private BigDecimal total_price;
    private Date order_date;
    private OrderStatus status;
    private List<Bucket> bucket;

    public OrderDTO() {
    }

    public OrderDTO(long id, long user_id, BigDecimal total_price, Date order_date, OrderStatus status, List<Bucket> bucket) {
        this.id = id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.order_date = order_date;
        this.status = status;
        this.bucket = bucket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Bucket> getBucket() {
        return bucket;
    }

    public void setBucket(List<Bucket> bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                ", order_date=" + order_date +
                ", status=" + status +
                ", bucket=" + bucket +
                '}';
    }
}
