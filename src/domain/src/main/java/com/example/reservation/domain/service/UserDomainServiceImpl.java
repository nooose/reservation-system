package com.example.reservation.domain.service;

import com.example.reservation.domain.dto.web.MemberForm;
import com.example.reservation.domain.dto.web.UserForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.type.MemberRoleType;
import com.example.reservation.exception.MemberException;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
@Primary
public class UserDomainServiceImpl implements MemberDomainService{

    private final MemberRepository memberRepository;

    @Override
    public void join(MemberForm memberForm) {
        UserForm userForm = new UserForm(memberForm.getEmail(), memberForm.getPassword1(), memberForm.getPassword2(),
                memberForm.getNickName(), memberForm.getName(), memberForm.getPhoneNumber(), memberForm.getCity(), memberForm.getStreet());

        User user = userForm.toUserEntity();

        memberRepository.save(user);
        log.info("{} 회원 저장", user.getEmail());
    }

    @Override
    public void validateMember(MemberForm memberForm) throws MemberException {
        if (memberRepository.findByEmail(memberForm.getEmail()).isPresent()) {
            log.warn("중복 Email={}", memberForm.getEmail());
            throw new MemberException(memberForm.getEmail() + "은(는) 중복된 이메일입니다.", memberForm);
        }

        if (!memberForm.getPassword1().equals(memberForm.getPassword2())) {
            throw new MemberException("비밀번호가 일치하지 않습니다.", memberForm);
        }

    }

    @Override
    public Member getMember(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        return byId.orElseThrow(() -> new IllegalStateException("특정 회원이 없습니다."));
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAllByMemberRole(MemberRoleType.BASIC);
    }

    @Override
    public void updateMember(Long id, Member member) {
        User findMember = (User) getMember(id);

        findMember.changeNickName(member.getNickName());
        findMember.changePassword(member.getPassword());
        findMember.changeAddress(member.getAddress());
        findMember.changePhoneNumber(member.getPhoneNumber());
    }

    @Override
    public void deleteMember(Long id) {
        Member member = getMember(id);
        memberRepository.delete(member);
    }

}
