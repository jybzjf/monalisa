package com.gwin.example.jpa.repository;

import com.gwin.example.jpa.entity.Order;
import com.gwin.example.jpa.entity.Customer;
import com.gwin.example.jpa.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2019-08-27.
 *
 * @author: jiyanbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class JpaOrderRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private IOrderRepository repository;
    @Test
    @Rollback(false)
    public void testSave(){
        Order order = new Order();
        order.setOrderNum("test_order_0001");
        Customer customer = new Customer();
        customer.setIdCard("320306");
        customer.setName("dasouche");
        order.setCustomer(customer);

        Item item = new Item();
        item.setName("item 01");
        item.setCount(1);
        Item item2 = new Item();
        item2.setName("item 02");
        item2.setCount(2);
        order.appendItem(item);
        order.appendItem(item2);

        repository.save(order);

        Order order1 = repository.get(order.getId());


    }

    @Test
    public void testGet(){
        Order order = repository.get(2L);
        System.out.println(order.getCustomer());
        System.out.println(order.getItems().size());
    }
}
