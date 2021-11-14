package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.CompanyCategory;
import com.example.reservation.domain.enumtype.MemberRole;
import lombok.AllArgsConstructor;
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
    private CompanyCategory companyCategory;

    @Builder
    public Company(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRole memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, String registrationNumber, String description, CompanyCategory companyCategory) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.registrationNumber = registrationNumber;
        this.description = description;
        this.companyCategory = companyCategory;
    }
}
