package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Flower;
import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FlowerStockDaoImpl implements FlowerStockDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FlowerStock> findAll() {
        TypedQuery<FlowerStock> q = em.createQuery(" Select  f from FlowerStock f ", FlowerStock.class);
        return q.getResultList();
    }

//    @Override
//    public long getCountById(long id) {
//
//        return em.find(FlowerStock.class, id).getCount();
//    }

}
