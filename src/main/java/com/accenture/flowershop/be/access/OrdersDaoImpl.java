package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
@Transactional
public class OrdersDaoImpl implements OrdersDao{

    @PersistenceContext
    private EntityManager em;

    @Autowired
   private UserDao userDao;

   public boolean createOrder(long user_id, Date order_date){
       if(userDao.getUserById(user_id)!=null){
        Orders orders=new Orders();
        orders.setUser_id(user_id);
        orders.setTotal_price(new BigDecimal(0));
        orders.setOrder_date(order_date);
        orders.setStatus(OrderStatus.DRAFT);
        em.persist(orders);
        return true;
       }return  false;

        }

}
