package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Admin;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class AdminDomainService implements MemberDomainService{


    private final MemberRepository memberRepository;

    @Override
    public void saveMember(Member member) {
        Admin admin = (Admin) member;
        memberRepository.save(admin);
        log.info("{} 어드민 저장", admin.getName());
    }

    @Override
    public Member getMember(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        Member member = byId.orElseThrow(()-> new IllegalArgumentException("특정 회원이 없습니다."));
        return member;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void updateMember(Long id, Member member) {

        Admin findAdmin = (Admin) getMember(id);

        findAdmin.changeNickName(member.getNickName());
        findAdmin.changeAddress(member.getAddress());
        findAdmin.changePassword(member.getPassword());
        findAdmin.changePhoneNumber(member.getPhoneNumber());
    }

    @Override
    public void deleteMember(Long id) {
        Member member = getMember(id);
        memberRepository.delete(member);
    }
}
