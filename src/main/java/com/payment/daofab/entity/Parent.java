package com.payment.daofab.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent")
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sender;
    private String receiver;
    private Double totalAmount;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList;
}
