package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("U")
@NoArgsConstructor
@Getter
public class User extends Member{
    private int point;

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    @Builder
    private User(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRoleType memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, int point) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.point = point;
    }

    @Override
    public String toString() {
        return "User.email = " + this.getEmail() + "\n"
                + "User.nickName = " + this.getNickName() + "\n"
                + "User.name = " + this.getName() + "\n"
                + "User.phoneNumber = " + this.getPhoneNumber() + "\n"
                + "User.role = " + this.getMemberRole() + "\n"
                + "User.point = " + this.getPoint() + "\n";
    }
}
