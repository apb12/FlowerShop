package com.accenture.flowershop.be.access;

import com.accenture.flowershop.fe.dto.User;

import java.util.List;

public interface UserDao {
     User getUserByLogin(String login);
}
