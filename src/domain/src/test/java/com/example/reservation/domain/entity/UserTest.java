package com.example.reservation.domain.entity;

import com.example.reservation.domain.service.MemberDomainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserTest {

    @Autowired
    private MemberDomainService memberDomainService;

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
        String phoneNumber1 = "010-7236-1800";
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
        assertThat(phoneNumberA).isEqualTo(true);
        assertThat(phoneNumberB).isEqualTo(true);
        assertThat(phoneNumberC).isEqualTo(false);
        assertThat(phoneNumberD).isEqualTo(false);
        assertThat(phoneNumberE).isEqualTo(false);
    }

    @Test
    @DisplayName("이메일주소 정규식 테스트")
    public void emailRegExpTest() {
        //given
        String email1 = "test@test.com";
        String email2 = "Covid_19@test.co.kr";
        String email3 = "sibal!@test.com";
        
        //when
        boolean emailRegExp = memberDomainService.emailRegExp(email1);
        boolean emailRegExp1 = memberDomainService.emailRegExp(email2);
        boolean emailRegExp2 = memberDomainService.emailRegExp(email3);

        //then
        assertThat(emailRegExp).isEqualTo(true);
        assertThat(emailRegExp1).isEqualTo(true);
        assertThat(emailRegExp2).isEqualTo(false);
    }


}