package com.example.reservation.repository;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.type.MemberRoleType;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Member> findAllByMemberRole(MemberRoleType memberRoleType);

    Optional<Member> findByEmail(String email);

    void save(Member member);

    Optional<Member> findById(Long id);

    void delete(Member member);
}
