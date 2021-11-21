package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.UserDto;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.MemberService;
import com.example.reservation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public UserServiceImpl(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
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
            log.info("{} 가입 성공", newUser.getEmail());
        } else {
            // 예외 처리
            log.info("{} 가입 실패", newUser.getEmail());
        }

        return newUser;
    }

    public User findUserById(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        User user = (User) byId.orElseGet(() -> {
            log.info("{} 사용자 조회 실패", id);
            return new User();
        });

        log.info("{} 사용자 조회 성공", user.getEmail());
        return user;
    }

    public List<User> findUsers() {
        List<Member> users = memberRepository.findAll();
        log.info("모든 사용자 조회");
        return users.stream().map(i -> (User) i).collect(Collectors.toList());
    }
 }
