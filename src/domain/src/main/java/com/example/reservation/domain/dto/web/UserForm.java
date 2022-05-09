package com.example.reservation.domain.dto.web;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.type.MemberRoleType;




public class UserForm extends MemberForm{

    public UserForm(String email, String password1, String password2, String nickName, String name, String phoneNumber, String city, String street) {
        super(email, password1, password2, nickName, name, phoneNumber, city, street);
    }

    public User toUserEntity() {
        return User.builder()
                .email(this.getEmail()).password(this.getPassword1())
                .nickName(this.getNickName()).name(this.getName())
                .phoneNumber(this.getPhoneNumber()).address(new Address(this.getCity(), this.getStreet()))
                .memberRole(MemberRoleType.BASIC)
                .build();
    }
}
