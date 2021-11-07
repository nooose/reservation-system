package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.CompanyCategory;
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
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter
public class Company extends Member{

    private String registrationNumber;
    private String description;

    @Enumerated(EnumType.STRING)
    private CompanyCategory companyCategory;

    @Builder
    public Company(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRole memberRole, LocalDateTime createdAt, LocalDateTime lastLogin, String registrationNumber, String description, CompanyCategory companyCategory) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, createdAt, lastLogin);
        this.registrationNumber = registrationNumber;
        this.description = description;
        this.companyCategory = companyCategory;
    }
}
