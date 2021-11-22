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


    public User findUserById(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        return (User) byId.orElseGet(User::new);
    }

    public List<User> findUsers() {
        List<Member> users = memberRepository.findAll();
        return users.stream().map(i -> (User) i).collect(Collectors.toList());
    }
}
