package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.service.UserDomainServiceImpl;
import com.example.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Primary
public class UserServiceImpl implements MemberService {

    private final UserDomainServiceImpl userDomainServiceImpl;

    @Override
    @Transactional
    public void join(MemberForm memberForm) {
        userDomainServiceImpl.validateMember(memberForm);
        userDomainServiceImpl.join(memberForm);
    }

    @Override
    @Transactional
    public void update(Long id, Member member) {
        userDomainServiceImpl.updateMember(id, member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id) {
        return userDomainServiceImpl.getMember(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> getMembers() {

        return userDomainServiceImpl.getMembers();
    }

    @Override
    public void remove(Long id) {
        userDomainServiceImpl.deleteMember(id);
    }
}
