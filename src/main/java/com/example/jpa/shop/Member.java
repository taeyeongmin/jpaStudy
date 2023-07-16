package com.example.jpa.shop;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();

    private String name;
    private String city;
    private String street;
    private String zipcode;
}
