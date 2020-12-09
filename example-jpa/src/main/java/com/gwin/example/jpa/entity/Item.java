package com.gwin.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on 2019-08-27.
 *
 * @author: jiyanbin
 */
@Data
@Embeddable
//@Table(name = "example_jpa_order_item")
public class Item {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    //@SequenceGenerator(name = "order_id_seq",sequenceName = "order_id_seq")
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private Integer count;
}
