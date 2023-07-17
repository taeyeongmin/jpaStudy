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
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "STOCK_QUANTITY")
    private int stockQuantity;
}
