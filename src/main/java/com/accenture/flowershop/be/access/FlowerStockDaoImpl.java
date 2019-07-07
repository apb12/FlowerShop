package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.FlowerStock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FlowerStockDaoImpl implements FlowerStockDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long getCountById(long id) {

        return em.find(FlowerStock.class, id).getCount();
    }
}
