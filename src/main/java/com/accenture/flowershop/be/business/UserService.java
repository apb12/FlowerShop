package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.User;

public interface UserService {
    boolean login(String login, String password);

    boolean loginExist(String login);
}
