package com.example.reservation.domain.dto;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.type.CompanyCategoryType;
import com.example.reservation.domain.type.MemberRoleType;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RequestCompanyDto {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String nickName;
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Address address;

    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String description;
    @NotBlank
    private String companyName;
    @NotBlank
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
