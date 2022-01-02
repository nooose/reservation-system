package com.example.reservation.domain.dto.api;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.Admin;
import com.example.reservation.domain.type.AdminGradeType;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Data;

@Data
public class RequestAdminDto {

    private String email;
    private String password;
    private String name;
    private String nickName;
    private String phoneNumber;
    private Address address;

    private AdminGradeType adminGradeType;


    public Admin toEntity(){
        return createAdmin(this.email,this.password,this.name,this.nickName,this.phoneNumber,this.address,this.adminGradeType);
    }

    private Admin createAdmin(String email, String password, String name, String nickName,
                              String phoneNumber, Address address, AdminGradeType adminGradeType){
        return Admin.builder().
                email(email).password(password).name(name).
                nickName(nickName).memberRole(MemberRoleType.ADMIN).
                phoneNumber(phoneNumber).address(address).
                adminGradeType(adminGradeType).build();

    }
}
