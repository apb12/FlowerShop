package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public Users getUserByLogin(String login) {
        return em.find(Users.class, login);
    }

    @Override
    public boolean registration(String login, String password, String name, String email) {
        if (getUserByLogin(login) == null) {
            em.persist(new Users(login, password, name, email, new BigDecimal(2000), 5));
            return true;
        }
        return false;

//    public Users getUserByLogin(String userLogin) {
//            TypedQuery<Users> q = em.createQuery(" Select u from Users u where u.userLogin = :ul",Users.class);
//            q.setParameter("ul", userLogin);
//            return q.getSingleResult();
//        }

    }
}


