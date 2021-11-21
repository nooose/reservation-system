package com.example.reservation.service.Impl;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean doubleCheck(Member newMember) {
        return doubleCheckByEmail(newMember) & doubleCheckByPhoneNumber(newMember);
    }



    private boolean doubleCheckByEmail(Member newMember) {
        Optional<Member> byEmail = memberRepository.findByEmail(newMember.getEmail());
        User userByEmail = (User) byEmail.orElseGet(User::new);

        if (userByEmail.isNull()) {
            return true;
        } else {
            log.info("{} email 중복", newMember.getEmail());
            return false;
        }
    }

    private boolean doubleCheckByPhoneNumber(Member newMember) {
        Optional<Member> byPhoneNumber = memberRepository.findByPhoneNumber(newMember.getPhoneNumber());
        User userByPhoneNumber = (User) byPhoneNumber.orElseGet(User::new);

        if (userByPhoneNumber.isNull()) {
            return true;
        } else {
            log.info("{} 휴대폰 번호 중복", newMember.getPhoneNumber());
            return false;
        }
    }

}
