package com.example.jpa.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Member {
    @Id @GeneratedValue/*(strategy = GenerationType.IDENTITY)*/
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMemberList().add(this);
    }
}
