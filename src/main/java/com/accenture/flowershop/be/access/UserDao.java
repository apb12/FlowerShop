package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Users;

import java.math.BigDecimal;

public interface UserDao {
    Users getUserByLogin(String login);

    boolean registration(String login, String password, String name, String email);

    Users getUserById(long id);

    void userCashUpdate(long id, BigDecimal cash);

    void userDiscountUpdate(String login, Integer discount);
}
