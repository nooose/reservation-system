package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("U")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User extends Member{
    private int point;


    @Builder
    public User(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRole memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, int point) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.point = point;
    }
}
