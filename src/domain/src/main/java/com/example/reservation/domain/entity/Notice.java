package com.example.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Notice extends Board{

}
