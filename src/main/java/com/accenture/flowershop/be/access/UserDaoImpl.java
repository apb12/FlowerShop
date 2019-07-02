package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public Users getUserByLogin(String login) {
        return em.find(Users.class, login);
    }

//    public Users getUserByLogin(String userLogin) {
//            TypedQuery<Users> q = em.createQuery(" Select u from Users u where u.userLogin = :ul",Users.class);
//            q.setParameter("ul", userLogin);
//            return q.getSingleResult();
//        }

    }


