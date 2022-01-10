package com.example.reservation.repository.impl;

import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.type.MemberRoleType;
import com.example.reservation.repository.MemberJpaRepository;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public void save(Member member) {
        memberJpaRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberJpaRepository.findById(id);
    }

    @Override
    public List<Member> findAllByMemberRole(MemberRoleType memberRoleType) {
        return memberJpaRepository.findAllByMemberRole(memberRoleType);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmail(email);
    }

    @Override
    public void delete(Member member) {
        memberJpaRepository.delete(member);
    }

}
