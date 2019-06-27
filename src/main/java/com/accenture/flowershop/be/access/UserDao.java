package com.accenture.flowershop.be.access;

import com.accenture.flowershop.fe.dto.User;

public interface UserDao {
    User getUserByLogin(String login);

}
