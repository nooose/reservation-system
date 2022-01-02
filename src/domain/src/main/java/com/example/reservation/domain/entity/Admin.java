package com.example.reservation.domain.entity;


import com.example.reservation.domain.Address;
import com.example.reservation.domain.dto.api.ResponseAdminDto;
import com.example.reservation.domain.type.AdminGradeType;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor
@Getter
public class Admin extends Member{
    @Enumerated(EnumType.STRING)
    private AdminGradeType adminGradeType;

    @Builder
    public Admin(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRoleType memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, AdminGradeType adminGradeType) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.adminGradeType = adminGradeType;
    }

    public ResponseAdminDto toResponseDto(){
        ResponseAdminDto responseAdminDto = new ResponseAdminDto();
        responseAdminDto.setEmail(this.getEmail());
        responseAdminDto.setName(this.getName());
        responseAdminDto.setNickName(this.getNickName());

        return responseAdminDto;
    }
}
