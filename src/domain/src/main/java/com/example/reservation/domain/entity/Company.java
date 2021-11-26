package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.type.CompanyCategoryType;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter
public class Company extends Member{

    private String registrationNumber;
    private String description;

    @OneToMany(mappedBy = "company")
    private List<Item> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CompanyCategoryType companyCategory;

    @Builder
    public Company(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRoleType memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, String registrationNumber, String description, CompanyCategoryType companyCategory) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.registrationNumber = registrationNumber;
        this.description = description;
        this.companyCategory = companyCategory;
    }
}
