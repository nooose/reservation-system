package com.example.reservation.domain.service;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.type.MemberRoleType;
import com.example.reservation.repository.ItemRepository;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class CompanyDomainService implements MemberDomainService{

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    public void join(MemberForm member) {
//        Company company = (Company) member;
//        memberRepository.save(company);
//        log.info("{} 업체 저장", company.getCompanyName());
    }

    @Override
    public void validateMember(MemberForm memberForm) {

    }

    @Override
    public Member getMember(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        Company company = (Company) byId.orElseThrow(() -> new IllegalStateException("특정 회원이 없습니다."));
        log.info("{} 업체 조회", company.getCompanyName());
        return company;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAllByMemberRole(MemberRoleType.COMPANY);
    }

    @Override
    public void updateMember(Long id, Member member) {
        Company company = (Company) member;
        Company findMember = (Company) getMember(id);

        findMember.changeNickName(member.getNickName());
        findMember.changePassword(member.getPassword());
        findMember.changeAddress(member.getAddress());
        findMember.changePhoneNumber(member.getPhoneNumber());
        findMember.changeCompanyName(company.getCompanyName());
    }

    @Override
    public void deleteMember(Long id) {
        Member member = getMember(id);
        memberRepository.delete(member);
    }

}
