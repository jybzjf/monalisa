package com.gwin.example.jpa.repository;


import com.gwin.example.jpa.entity.Order;
import com.souche.finance.common.ddd.event.DomainEvent;

/**
 * Created on 2019-08-02.
 *
 * @author: jiyanbin
 */

public interface IOrderRepository {

    void save(Order order);

    Order get(Long id);
}
