package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
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

    /**
     * TO-DO 주소 정규식
     */
    // 010-4자리-4자리
    public boolean phoneNumberRegExp(String phoneNumber) {

        String regExp = "^010[-]?(\\d{4})[-]?(\\d{4})$"; // 010-7236-1800 or 01072361800

        return phoneNumber.matches(regExp);
    }

    // 이메일 정규식
    public boolean emailRegExp(String email){
        String regExp = "^[a-zA-Z0-9_-]+@[a-zA-Z.]+\\.[a-zA-Z]{2,6}$";
        return email.matches(regExp);
    }
}
