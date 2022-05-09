package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.type.MemberRoleType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String nickName;

    private String name;

    private String phoneNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MemberRoleType memberRole;

    @OneToMany(mappedBy = "member")
    List<Board> boards = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;


    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User toUserObject() {
        return (User) this;
    }
}
