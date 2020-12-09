package com.gwin.example.jpa.entity;

import com.souche.finance.common.ddd.model.AbstractId;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * Created on 2019-10-08.
 *
 * @author: jiyanbin
 */
@Embeddable
public class OrderId extends AbstractId<Long> {

    @Id
    private Long id;
}
