package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.enitity.Orders;

import java.math.BigDecimal;
import java.util.List;

public class UserDTO {
    private long id;
    private String login;
    private String password;
    private String username;
    private String email;
    private BigDecimal balance;
    private Integer discount;
    private List<Orders> ordersList;

    public UserDTO() {
    }

    public UserDTO(long id, String login, String password, String username, String email, BigDecimal balance, Integer discount, List<Orders> ordersList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
        this.email = email;
        this.balance = balance;
        this.discount = discount;
        this.ordersList = ordersList;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getDiscount() {
        return discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                ", ordersList=" + ordersList +
                '}';
    }
}

