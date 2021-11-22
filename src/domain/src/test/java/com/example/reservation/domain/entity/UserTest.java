package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(false)
class UserTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("user 저장 및 조회 테스트")
    void findUserTest(){
        // given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();
        
        // when
        memberRepository.save(user);
        User findUser = (User) memberRepository.findById(user.getId()).get();


        // then
        System.out.println("=====");
        assertThat(findUser.getName()).isEqualTo("test");
        assertThat(findUser.getPoint()).isEqualTo(100);
    }

    @Test
    @DisplayName("JPA Audit 테스트")
    void auditTest(){
        // given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();
        
        // when
        memberRepository.save(user);
        Member findUser = memberRepository.findById(user.getId()).get();

        //then
        System.out.println("=====");
        assertThat(findUser.getCreatedAt()).isNotEqualTo(LocalDateTime.now());
    }
    
    @Test
    @DisplayName("Builder 테스트")
    void buildTest() {
        // given
        User user = User.builder()
                .lastLogin(LocalDateTime.now())
                .id(1L).email("test@test.com")
                .build();
        
        // when
        
        // then
        assertThat(user.getEmail()).isEqualTo("test@test.com");
        assertThat(user.getName()).isNull();
        assertThat(user.getId()).isNotEqualTo(2L);
    }
    
    
    @Test 
    @DisplayName("toString 출력 테스트")
    public void toStringTest() { 
        // given  
        User user = new User();
        
        // when
        System.out.println("user.toString() = " + user.toString());
        
        // then
    }


}