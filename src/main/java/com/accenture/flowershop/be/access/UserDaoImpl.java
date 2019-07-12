package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public Users getUserById(long id) {
        return em.find(Users.class, id);
    }

    @Override
    public boolean registration(String login, String password, String name, String email) {
        if (getUserByLogin(login) == null) {
            Users user = new Users();
            user.setLogin(login);
            user.setPassword(password);
            user.setUsername(name);
            user.setEmail(email);
            user.setBalance(new BigDecimal(2000));
            user.setDiscount(5);
            em.persist(user);
            return true;
        }
        return false;
    }

    public Users getUserByLogin(String login) {
       try{ TypedQuery<Users> q = em.createQuery(" Select u from Users u where u.login =:ul",Users.class);
        q.setParameter("ul", login);
        return q.getSingleResult();}
       catch (Exception e){
        return null;}
}

    }



