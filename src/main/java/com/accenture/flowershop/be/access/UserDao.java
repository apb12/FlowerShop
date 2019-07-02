package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Users;

public interface UserDao {
    Users getUserByLogin(String login);
    boolean registration(String login,String password,String name,String email);

}
