package com.example.reservation.service;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Member;

import java.util.List;

public interface MemberService {

    void join(MemberForm member);

    void update(Long id, Member member);

    Member getMember(Long id);

    List<Member> getMembers();

    void remove(Long id);
}
