package com.example.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Movie extends Item{

    private String director;
    private String actor;

}
