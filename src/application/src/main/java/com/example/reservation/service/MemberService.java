package com.example.reservation.service;

import com.example.reservation.domain.entity.Member;

public interface MemberService {

    boolean doubleCheck(Member newMember);
}
