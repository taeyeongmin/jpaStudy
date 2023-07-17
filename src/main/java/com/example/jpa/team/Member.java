package com.example.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
