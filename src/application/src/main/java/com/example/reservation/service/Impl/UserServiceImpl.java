package com.example.reservation.service.Impl;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.service.UserDomainServiceImpl;
import com.example.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements MemberService {

    private final UserDomainServiceImpl userDomainServiceImpl;

    @Override
    public void join(Member member) {
        userDomainServiceImpl.saveMember(member);
    }

    @Override
    @Transactional
    public void update(Long id, Member member) {
        userDomainServiceImpl.updateMember(id, member);
    }

    @Override
    public Member getMember(Long id) {
        return userDomainServiceImpl.getMember(id);
    }

    @Override
    public List<Member> getMembers() {
        return userDomainServiceImpl.getMembers();
    }

    @Override
    public void remove(Long id) {
        userDomainServiceImpl.deleteMember(id);
    }
}
