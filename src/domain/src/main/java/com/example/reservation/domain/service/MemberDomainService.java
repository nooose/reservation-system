package com.example.reservation.domain.service;


import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Member;

import java.util.List;

public interface MemberDomainService {

    void join(MemberForm memberForm);

    void validateMember(MemberForm memberForm);

    Member getMember(Long id);

    List<Member> getMembers();

    void updateMember(Long id, Member member);

    void deleteMember(Long id);

}
