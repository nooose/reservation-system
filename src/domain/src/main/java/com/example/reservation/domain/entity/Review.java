package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.ReviewRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Review extends Board {

    // Order와 일대일 맵핑
    @OneToOne(mappedBy = "review")
    private Order order;

    @Enumerated(EnumType.STRING)
    private ReviewRating reviewRating;

}
