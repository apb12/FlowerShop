package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.enitity.Flower;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FlowerDaoImpl implements FlowerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Flower> findAll() {

            TypedQuery<Flower> q = em.createQuery(" Select  f from Flower f ",Flower.class);

            return q.getResultList();
        }


    @Override
    public void removeFlower(long id) {

    }

    @Override
    public List<Flower> sortAsc() {
        return null;
    }

    @Override
    public List<Flower> sortDesc() {
        return null;
    }
}
