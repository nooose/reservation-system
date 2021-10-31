package com.example.reservation.domain.entity;


import com.example.reservation.domain.AdminGrade;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("A")
@Getter
public class Admin extends Member{
    @Enumerated(EnumType.STRING)
    private AdminGrade adminGrade;

}
