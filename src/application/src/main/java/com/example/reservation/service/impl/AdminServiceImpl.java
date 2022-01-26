package com.example.reservation.service.impl;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.service.AdminDomainService;
import com.example.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements MemberService {

    private final AdminDomainService adminDomainService;

    @Override
    public void join(MemberForm member) {
//        adminDomainService.joinMember(member);
    }

    @Override
    @Transactional
    public void update(Long id, Member member) {
        adminDomainService.updateMember(id, member);
    }

    @Override
    public Member getMember(Long id) {
        return adminDomainService.getMember(id);
    }

    @Override
    public List<Member> getMembers() {
        return adminDomainService.getMembers();
    }

    @Override
    public void remove(Long id) {
        adminDomainService.deleteMember(id);
    }
}
