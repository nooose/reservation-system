package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("U")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User extends Member{
    private int point;

    public User(Long id, String email, String password, String name, String nickName, String phoneNumber, Address address, Date date, MemberRole memberRole, int point) {
        super(id, email, password, name, nickName, phoneNumber, address, date, memberRole);
        this.point = point;
    }
}
