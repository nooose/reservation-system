package com.example.reservation.domain.service;


import com.example.reservation.domain.entity.Member;

import java.util.List;

public interface MemberDomainService {

    void saveMember(Member member);

    Member getMember(Long id);

    List<Member> getMembers();

    void updateMember(Long id, Member member);

    void deleteMember(Long id);

}
