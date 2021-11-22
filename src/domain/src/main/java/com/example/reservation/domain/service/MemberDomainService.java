package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MemberDomainService {

    private final MemberRepository memberRepository;

    public MemberDomainService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }




    public User saveUser(User user, boolean isEmail, boolean isPhoneNumber) {
        User newUser = new User();

        if ( isEmail & isPhoneNumber ) {
            newUser = memberRepository.save(user);
            log.info("{} 회원 저장", user.getEmail());
            return newUser;
        }

        return newUser;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        Optional<Member> findMemberById = memberRepository.findByPhoneNumber(phoneNumber);
        Member findMember = findMemberById.orElseGet(() -> null);

        if (findMember != null) {
            log.info("{} 이미 존재하는 휴대폰 번호입니다.", phoneNumber);
        }

        return findMember == null;
    }

    public boolean checkEmail(String email) {
        Optional<Member> findMemberByPhoneNumber = memberRepository.findByEmail(email);
        Member findMember = findMemberByPhoneNumber.orElseGet(() -> null);

        if (findMember != null) {
            log.info("{} 이미 존재하는 이메일입니다.", email);
        }

        return findMember == null;
    }
}
