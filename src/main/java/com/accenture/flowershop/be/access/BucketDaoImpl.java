package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Bucket;
import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Repository
public class BucketDaoImpl implements BucketDao {

    @Autowired
    private FlowerDao flowerDao;
    @Autowired
    private OrdersDao ordersDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertBucket(long orders_id, long flower_id, long amount) {
        Flower flower=flowerDao.findById(flower_id);
        Orders orders=ordersDao.findOrdersById(orders_id);
        long sum=flower.getPrice().longValue()*amount;
        Bucket bucket=new Bucket();
        bucket.setOrders(orders);
        bucket.setFlower(flower);
        bucket.setAmount(amount);
        bucket.setPrice(new BigDecimal(sum));
        em.persist(bucket);


    }
}
