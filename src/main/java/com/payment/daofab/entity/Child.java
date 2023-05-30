package com.payment.daofab.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "child")
@Data
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double paidAmount;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
