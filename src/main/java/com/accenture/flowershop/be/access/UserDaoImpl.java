package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.UserEnitity;
import com.accenture.flowershop.fe.dto.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;
   // private List<User> userList = new ArrayList<>(Arrays.asList(new User("aa", "11"), new User("notadmin", "12345"),new User("admin","admin123")));

//    @Override
//    public User getUserByLogin(String login) {
//        for (User s : userList) {
//            if (s.getLogin().equalsIgnoreCase(login)) {
//                return s;
//            }
//        }
//        return null;
//    }
    public UserEnitity getUserByLogin(String login){
        return em.find(UserEnitity.class,login);
    }
}

