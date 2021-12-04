package com.example.reservation.domain.dto;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.type.CompanyCategoryType;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Data;

@Data
public class RequestCompanyDto {
    private String email;
    private String password;
    private String nickName;
    private String name;
    private String phoneNumber;
    private Address address;

    private String registrationNumber;
    private String description;
    private String companyName;
    private CompanyCategoryType companyCategoryType;

    public Company toEntity() {
        return createCompany(this.email, this.password, this.nickName,
                            this.name, this.phoneNumber, this.address,
                            this.registrationNumber, this.description, this.companyName, this.companyCategoryType);
    }

    private Company createCompany(String email, String password,
                                  String nickName, String name,
                                  String phoneNumber, Address address,
                                  String registrationNumber, String description,
                                  String companyName, CompanyCategoryType companyCategoryType) {
        return Company.builder()
                .email(email).password(password)
                .nickName(nickName).name(name)
                .phoneNumber(phoneNumber).address(address)
                .memberRole(MemberRoleType.COMPANY).companyCategory(companyCategoryType)
                .registrationNumber(registrationNumber).description(description)
                .companyName(companyName)
                .build();
    }
}
