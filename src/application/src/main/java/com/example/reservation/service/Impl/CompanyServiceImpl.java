package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.entity.Item;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.service.CompanyDomainService;
import com.example.reservation.domain.service.ItemDomainService;
import com.example.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements MemberService {

    private final CompanyDomainService companyDomainService;
    private final ItemDomainService itemDomainService;

    @Override
    public void join(MemberForm member) {
//        companyDomainService.joinMember(member);
    }

    @Override
    @Transactional
    public void update(Long id, Member member) {
        companyDomainService.updateMember(id, member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id) {
        return companyDomainService.getMember(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> getMembers() {
        return companyDomainService.getMembers();
    }

    @Override
    public void remove(Long id) {
        companyDomainService.deleteMember(id);
    }

    @Transactional
    public void createItem(Long id, Item item) {
        Company company = (Company) companyDomainService.getMember(id);
        item.setCompany(company);
        itemDomainService.saveItem(item);
    }

    public void removeItem(Long companyId, Long itemId) {
        Company company = (Company) companyDomainService.getMember(companyId);
        Item item = itemDomainService.getItem(itemId);
        itemDomainService.removeItem(item);
    }
}
