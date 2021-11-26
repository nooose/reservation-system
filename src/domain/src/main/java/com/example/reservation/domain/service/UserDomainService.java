package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserDomainService {
    private final MemberRepository memberRepository;


    public UserDomainService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    public List<User> getUsers() {
        List<Member> members = memberRepository.findAll();

        log.info("모든 회원 정보 조회");

        return members.stream()
                .map(i -> (User) i)
                .collect(Collectors.toList());
    }


    public String getUsersCount(List<User> users) {
        return Integer.toString(users.size());
    }

    public User findUserById(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        return (User) byId.orElseGet(User::new);
    }

    public String getUserStatus(User user) {
        if ( user.isNullId() ) {
            return "해당 유저가 없습니다.";
        } else {
            return user.toString();
        }
    }

    public String deleteUser(User user) {
        if ( user.isNullId() ) {
            return "해당 유저가 없습니다.";
        } else {
            memberRepository.delete(user);
            return user.getName() + "님 \n삭제 되었습니다.";
        }
    }

}
