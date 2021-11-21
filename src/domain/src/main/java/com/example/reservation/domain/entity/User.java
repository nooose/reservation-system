package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
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
    private User(Long id, String email, String password, String nickName, String name, String phoneNumber, Address address, MemberRole memberRole, List<Board> boards, LocalDateTime createdAt, LocalDateTime lastLogin, int point) {
        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.point = point;
    }

    public static User createUser(String email, String password, String nickName, String name, String phoneNumber, Address address) {
        return User.builder()
                .email(email).password(password)
                .nickName(nickName).name(name)
                .phoneNumber(phoneNumber).address(address)
                .memberRole(MemberRole.BASIC).point(0)
                .build();
    }


    @Override
    public String toString() {
        return "User.email = " + this.getEmail() + "\n"
                + "User.nincName = " + this.getNickName() + "\n"
                + "User.name = " + this.getName() + "\n"
                + "User.phoneNumber = " + this.getPhoneNumber() + "\n"
                + "User.role = " + this.getMemberRole() + "\n"
                + "User.point = " + this.getPoint() + "\n";
    }
}
