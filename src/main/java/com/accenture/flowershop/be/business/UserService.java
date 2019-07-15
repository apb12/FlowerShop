package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.enitity.Users;

import java.math.BigDecimal;

public interface UserService {
    boolean login(String login, String password);

    boolean loginExist(String login);

    boolean registr(String login, String password, String name, String email);

    Users getUserByLogin(String login);
    void userCashUpdate(long id, BigDecimal cash);
    Users getUserById(long id);
}
