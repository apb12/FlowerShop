package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.UserEnitity;
import com.accenture.flowershop.fe.dto.User;

public interface UserDao {
    UserEnitity getUserByLogin(String login);

}
