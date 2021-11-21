package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.UserDto;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.MemberService;
import com.example.reservation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public UserServiceImpl(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }


    public String getStatus(Member member) {
        if ( !member.isNull() ) {
            return "생성 되었습니다.";
        } else {
            return "생성되지 않았습니다.";
        }
    }

    public User userToEntity(UserDto userDto) {
        return User.createUser(userDto.getEmail(), userDto.getPassword(), userDto.getNickName(), userDto.getName(), userDto.getPhoneNumber(), null);
    }

    public User joinUser(Member member) {
        User newUser = User.createUser(member.getEmail(), member.getPassword(),
                member.getNickName(), member.getName(),
                member.getPhoneNumber(), member.getAddress());


        if (memberService.doubleCheck(newUser)) {
            newUser = memberRepository.save(newUser);
            log.info("가입이 되었습니다.");
        } else {
            // 예외 처리
            log.info("중복회원 입니다.");
        }

        return newUser;
    }

}
