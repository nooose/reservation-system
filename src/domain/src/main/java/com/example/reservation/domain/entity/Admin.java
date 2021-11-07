package com.example.reservation.domain.entity;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.AdminGrade;
import com.example.reservation.domain.enumtype.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor
@Getter
public class Admin extends Member{
    @Enumerated(EnumType.STRING)
    private AdminGrade adminGrade;

    @Builder
    public Admin(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRole memberRole, LocalDateTime createdAt, LocalDateTime lastLogin, AdminGrade adminGrade) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, createdAt, lastLogin);
        this.adminGrade = adminGrade;
    }
}
