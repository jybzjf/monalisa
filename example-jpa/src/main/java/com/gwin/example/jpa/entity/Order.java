package com.gwin.example.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019-08-27.
 *
 * @author: jiyanbin
 */
@Data
@Entity
@Table(name = "example_jpa_order")
@SecondaryTables({
        @SecondaryTable(name = "example_jpa_order_customer",
                uniqueConstraints = {@UniqueConstraint(columnNames = "c_id")},
                pkJoinColumns = {@PrimaryKeyJoinColumn(name = "order_id")})
})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "order_id_seq",sequenceName = "order_id_seq")
    private Long id;
    @Column(name = "order_num")
    private String orderNum;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")*/
    @Basic(fetch = FetchType.LAZY)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="cid", column = @Column(name = "c_id",table = "example_jpa_order_customer")),
            @AttributeOverride(name="name", column = @Column(table = "example_jpa_order_customer")),
            @AttributeOverride(name="idCard", column = @Column(name = "id_card",table = "example_jpa_order_customer"))
    })
    private Customer customer;

    @ElementCollection(fetch = FetchType.LAZY)
    @Basic(fetch = FetchType.LAZY)
    @CollectionTable(name = "example_jpa_order_item",
            uniqueConstraints = @UniqueConstraint(columnNames = {"item_id"}),
            indexes = {@Index(columnList = "order_id")},
            joinColumns = {@JoinColumn(name = "order_id")})
    private List<Item> items;

    public void appendItem(Item item){
        if(items==null){
            items = new ArrayList<Item>();
        }
        items.add(item);
    }
}
