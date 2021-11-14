package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.ReviewRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
public class Review{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String contents;

    @OneToOne(mappedBy = "review")
    private Order order;

    @Enumerated(EnumType.STRING)
    private ReviewRating reviewRating;

    @CreatedDate
    private LocalDateTime createAt;

    @Builder
    public Review(Long id, String contents, Order order, ReviewRating reviewRating, LocalDateTime createAt) {
        this.id = id;
        this.contents = contents;
        this.order = order;
        this.reviewRating = reviewRating;
        this.createAt = createAt;
    }
}

