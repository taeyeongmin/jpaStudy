package com.example.jpa.shop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    private int price;
    private int stockQuantity;
}
