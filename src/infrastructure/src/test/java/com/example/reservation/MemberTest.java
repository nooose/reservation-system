package com.example.reservation;

import com.example.reservation.entity.Member;
import com.example.reservation.entity.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(false)
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("JPA 테스트")
    void test3() {
        //given
        Member member = new Member(1L, "jpa", 10);
        memberRepository.save(member);

        //when
        Optional<Member> byId = memberRepository.findById(member.getId());
        Member findMember = byId.get();

        //then
        assertThat(findMember.getName()).isEqualTo("jpa");
    }
}
