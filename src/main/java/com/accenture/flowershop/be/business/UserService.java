package com.accenture.flowershop.be.business;

public interface UserService {
    boolean login(String login, String password);

    boolean loginExist(String login);

    boolean registr(String login, String password, String name, String email);
}
