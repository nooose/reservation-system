package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.ReviewRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("R")
@NoArgsConstructor
@Getter
public class Review extends Board {

    @OneToOne(mappedBy = "review")
    private Order order;

    @Enumerated(EnumType.STRING)
    private ReviewRating reviewRating;

    @Builder
    public Review(Long id, String title, String contents, Member member, String category, LocalDateTime createdAt, Order order, ReviewRating reviewRating) {
        super(id, title, contents, member, category, createdAt);
        this.order = order;
        this.reviewRating = reviewRating;
    }
}
