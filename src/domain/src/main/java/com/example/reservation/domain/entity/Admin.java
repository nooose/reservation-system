package com.example.reservation.domain.entity;


import com.example.reservation.domain.AdminGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Admin extends Member{
    @Enumerated(EnumType.STRING)
    private AdminGrade adminGrade;

}
