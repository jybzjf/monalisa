package com.gwin.example.jpa.repository;

import com.gwin.example.jpa.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created on 2019-08-05.
 *
 * @author: jiyanbin
 */
@Slf4j
@Repository
public class JpaOrderRepository implements IOrderRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }

    public Order get(Long id) {
        return entityManager.find(Order.class,id);
    }
}
