package com.example.reservation.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Board {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String contents;

    private Member write;

    private String category;


    // private date date;
}
