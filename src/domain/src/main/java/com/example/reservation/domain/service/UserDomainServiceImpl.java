package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDomainServiceImpl implements MemberDomainService{

    private final MemberRepository memberRepository;

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
        log.info("{} 회원 저장", member.getEmail());
    }

    @Override
    public Member getMember(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        Member member = byId.orElseThrow(() -> new IllegalStateException("특정 회원이 없습니다."));
        return (User) member;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void updateMember(Long id, Member member) {
        User findMember = (User) getMember(id);

        findMember.changeNickName(member.getNickName());
        findMember.changePassword(member.getPassword());
        findMember.changeAddress(member.getAddress());
        findMember.changePhoneNumber(member.getPhoneNumber());
    }

    @Override
    public void deleteMember(Long id) {
        Member member = getMember(id);
        memberRepository.delete(member);
    }
}
