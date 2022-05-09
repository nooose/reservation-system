package com.example.reservation.domain.dto.web;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyForm {
    private String email;
    private String password1;
    private String password2;
    private String companyName;
    private String name;
    private String phoneNumber;
    private String city;
    private String street;

    public Company toEntity() {
        return Company.builder()
                .email(email).password(password1)
                .companyName(companyName).name(name)
                .phoneNumber(phoneNumber).address(new Address(city, street))
                .memberRole(MemberRoleType.COMPANY)
                .build();
    }
}
