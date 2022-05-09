package com.example.reservation.domain.dto.web;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminForm {
    private String email;
    private String password1;
    private String password2;
    private String nickName;
    private String name;
    private String phoneNumber;
    private String city;
    private String street;

    public User toEntity() {
        return User.builder()
                .email(email).password(password1)
                .nickName(nickName).name(name)
                .phoneNumber(phoneNumber).address(new Address(city, street))
                .memberRole(MemberRoleType.BASIC)
                .build();
    }
}
