package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Orders;
import com.accenture.flowershop.fe.dto.User;
import com.accenture.flowershop.fe.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
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

    @Override
    public Orders findOrdersById(long id) {
      return   em.find(Orders.class,id);
    }

           @Override
        public void updateOrders(long id, BigDecimal price, OrderStatus orderStatus) {
            Orders or=findOrdersById(id);
            or.setTotal_price(price);
            or.setStatus(orderStatus);
            em.merge(or);

    }

    @Override
    public void updateOrders(long id, OrderStatus orderStatus) {
       Orders or=findOrdersById(id);
       or.setStatus(orderStatus);
       em.merge(or);

    }

    @Override
    public List<Orders> findOrderByStatus(OrderStatus orderstatus) {
         TypedQuery<Orders> q = em.createQuery(" Select u from Orders u where u.status =:ul",Orders.class);
            q.setParameter("ul", orderstatus);
            return q.getResultList();}

    @Override
    public List<Orders> findOrderByUser(long id) {
        TypedQuery<Orders> q = em.createQuery(" Select u from Orders u where u.user_id =:ul",Orders.class);
        q.setParameter("ul", id);
        return q.getResultList();
    }

    @Override
   public  void  ordersDelete(long id) {
        Orders or=findOrdersById(id);
        em.remove(or);
    }


}


