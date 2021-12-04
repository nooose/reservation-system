package com.example.reservation.domain.dto;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Data;

@Data
public class RequestUserDto {
    private String email;
    private String password;
    private String nickName;
    private String name;
    private String phoneNumber;
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
