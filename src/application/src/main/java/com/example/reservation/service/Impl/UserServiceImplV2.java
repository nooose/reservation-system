package com.example.reservation.service.Impl;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.entity.Board;
import com.example.reservation.domain.entity.ServiceCenter;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.enumtype.ProcessType;
import com.example.reservation.repository.BoardRepository;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImplV2 implements UserService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public UserServiceImplV2(MemberRepository memberRepository, BoardRepository boardRepository) {
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void testSaveUser() {
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        User userA = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();

        User userB = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();






        memberRepository.save(userA);
        memberRepository.save(userB);
    }

    @Override
    public void testSaveuser2() {
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        List<Board> boardList = new ArrayList<>();
        User user = User.builder()
                .email("test@test.com").password("12345")
                .nickName("test5").name("test5")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .boards(boardList)
                .lastLogin(now)
                .point(100).build();

        memberRepository.save(user);

        ServiceCenter serviceCenterA = ServiceCenter.builder()
                .title("testTitle-A")
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();

        user.getBoards().add(serviceCenterA);
        serviceCenterA.setMember(user);

        boardRepository.save(serviceCenterA);

        ServiceCenter serviceCenterB = ServiceCenter.builder()
                .title("testTitle-B")
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();

        user.getBoards().add(serviceCenterB);
        serviceCenterB.setMember(user);

        boardRepository.save(serviceCenterB);


        System.out.println("serviceCenterB.getMember().getName() = " + serviceCenterB.getMember().getName());

        //then
        System.out.println("=====");

    }
}
