package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FlowerStockDaoImpl implements FlowerStockDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long getCountById(long id) {

        return em.find(FlowerStock.class,id).getCount();
    }
//@Override
//    public long getCountById(long id) {
//           // TypedQuery<FlowerStock> q = em.createQuery("SELECT d  FROM FlowerStock d, Flower m WHERE d = m.id  and m.id=:n",FlowerStock.class);
//            TypedQuery<FlowerStock> q = em.createQuery("select fs from FlowerStock fs, Flower fl where fs=fl.id and fl.id =:n",FlowerStock.class);
//            q.setParameter("n", id);
//            return q.getSingleResult().getCount();
//        }
}
