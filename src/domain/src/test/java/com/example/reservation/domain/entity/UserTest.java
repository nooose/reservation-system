package com.example.reservation.domain.entity;

import com.example.reservation.domain.service.MemberDomainService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(false)
class UserTest {


    private MemberDomainService memberDomainService;

    public UserTest(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
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

    @Test
    @DisplayName("핸드폰번호 정규식 테스트")
    public void phoneNumberRegExpTest() {
        //given
        String phoneNumber1 = "010git ad-7236-1800";
        String phoneNumber2 = "01072361800";
        String phoneNumber3 = "011-7236-1800";
        String phoneNumber4 = "010-7236-18000";
        String phoneNumber5 = "010-72365-8000";

        //when
        boolean phoneNumberA = memberDomainService.phoneNumberRegExp(phoneNumber1);
        boolean phoneNumberB = memberDomainService.phoneNumberRegExp(phoneNumber2);
        boolean phoneNumberC = memberDomainService.phoneNumberRegExp(phoneNumber3);
        boolean phoneNumberD = memberDomainService.phoneNumberRegExp(phoneNumber4);
        boolean phoneNumberE = memberDomainService.phoneNumberRegExp(phoneNumber5);

        //then
        Assertions.assertThat(phoneNumberA).isEqualTo(true);
        Assertions.assertThat(phoneNumberB).isEqualTo(true);
        Assertions.assertThat(phoneNumberC).isEqualTo(false);
        Assertions.assertThat(phoneNumberD).isEqualTo(false);
        Assertions.assertThat(phoneNumberE).isEqualTo(false);


    }

    @Test
    @DisplayName("이메일주소 정규식 테스트")
    public void emailRegExpTest() {
        //given
        User user = User.builder()
                .email("test@test.com").build();
        User user2 = User.builder()
                .email("Covid_19@test.co.kr").build();
        User user3 = User.builder()
                .email("sibal!@test.com").build();
        //when

        //then
//        System.out.println("user1 정규식 확인 결과 : " + user.emailRegExp(user.getEmail()));
//        System.out.println("user2 정규식 확인 결과 : " + user2.emailRegExp(user2.getEmail()));
//        System.out.println("user3 정규식 확인 결과 : " + user3.emailRegExp(user3.getEmail()));
    }


}