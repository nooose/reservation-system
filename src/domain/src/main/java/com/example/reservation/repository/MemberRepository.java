package com.example.reservation.repository;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.type.MemberRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByMemberRole(MemberRoleType memberRoleType);
}
