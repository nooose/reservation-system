package com.example.reservation.domain.entity;

import com.example.reservation.domain.CompanyCategory;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("C")
@Getter
public class Company extends Member{

    private String registrationNumber;
    private String description;

    @Enumerated(EnumType.STRING)
    private CompanyCategory companyCategory;
}
