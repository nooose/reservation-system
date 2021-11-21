package com.example.reservation.controller.test;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.dto.UserDto;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class TestController {

    private final MemberRepository memberRepository;
    private final UserServiceImpl userService;

    public TestController(MemberRepository memberRepository, UserServiceImpl userService) {
        this.memberRepository = memberRepository;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        Address address = new Address("서울시", "송파구", "123-456");
        User user = User.createUser("test@test.com", "12345", "테스트A", "박지수", "010-1234-5678", address);


        // when
        User newUser = userService.joinUser(user);
        Optional<Member> byId = memberRepository.findById(newUser.getId());
        User findUser = (User) byId.get();

        log.info("newUser = {}", newUser.toString());
        log.info("findUser = {}", findUser.toString());

        return newUser.toString();
    }


    @PostMapping("/user")
    public String saveUser(@RequestBody UserDto userDto) {
        System.out.println("===user.toString() = " + userDto.toString());

        User newUser = userService.joinUser(userService.userToEntity(userDto));

        log.info("===newUser = {}", newUser.toString());

        return userService.getStatus(newUser);
    }
}

