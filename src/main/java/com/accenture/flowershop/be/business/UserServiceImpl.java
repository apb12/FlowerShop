package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.UserDao;
import com.accenture.flowershop.be.enitity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String login, String password) {
        Users user = userDao.getUserByLogin(login);
        if (user != null && user.getPassword().equalsIgnoreCase(password)) {
            return true;
        }
        return false;
    }

    public boolean loginExist(String login) {
        if (userDao.getUserByLogin(login) != null) {
            return true;
        }
        return false;
    }
    @Transactional
    public boolean registr(String login, String password, String name, String email) {
        return userDao.registration(login, password, name, email);
    }

    @Override
    @Transactional
    public Users getUserByLogin(String login) {
        Users userByLogin = userDao.getUserByLogin(login);
       if( userByLogin.getOrdersList().size()>0){
        userByLogin.getOrdersList().get(userByLogin.getOrdersList().size()-1).getBucket().size();}
        return userByLogin;
    }
}
