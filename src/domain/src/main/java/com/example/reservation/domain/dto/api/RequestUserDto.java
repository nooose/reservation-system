package com.example.reservation.domain.dto.api;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.type.MemberRoleType;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RequestUserDto {
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


    public User toEntity() {
        return createUser(this.email, this.password, this.nickName, this.name, this.phoneNumber, this.address);
    }

    private User createUser(String email, String password, String nickName, String name, String phoneNumber, Address address) {
        return User.builder()
                .email(email).password(password)
                .nickName(nickName).name(name)
                .phoneNumber(phoneNumber).address(address)
                .memberRole(MemberRoleType.BASIC).point(0)
                .build();
    }
}
