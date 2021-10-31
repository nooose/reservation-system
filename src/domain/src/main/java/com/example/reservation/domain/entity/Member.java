package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.MemberRole;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "type")
@Getter
public abstract class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    private String nickName;

    private String phoneNumber;

    @Embedded
    private Address address;

    private Date date;

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
}
