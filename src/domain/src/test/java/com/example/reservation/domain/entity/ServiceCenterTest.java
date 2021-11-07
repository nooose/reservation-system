package com.example.reservation.domain.entity;

import com.example.reservation.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(value = false)
class ServiceCenterTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test

    void scTest(){
        //given
        ServiceCenter sc = new ServiceCenter();


        //when

        //then

    }

    @Test
    @DisplayName("")
    public void Test() {
        //given

        //when

        //then
    }

}