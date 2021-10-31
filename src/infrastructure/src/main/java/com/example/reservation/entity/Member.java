package com.example.reservation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;
}
