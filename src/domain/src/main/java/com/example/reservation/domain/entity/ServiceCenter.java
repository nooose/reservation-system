package com.example.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("SC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ServiceCenter extends Board{

    @Enumerated(EnumType.STRING)
    private Process process;
}
