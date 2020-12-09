package com.gwin.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on 2019-08-27.
 *
 * @author: jiyanbin
 */
@Data
//@Entity
//@Table(name = "example_jpa_order_customer")
@Embeddable
public class Customer {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/

    @Column(name = "c_id")
    private Long cid;

    @Column(name = "name")
    private String name;

    @Column(name = "id_card")
    private String idCard;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;*/
}
