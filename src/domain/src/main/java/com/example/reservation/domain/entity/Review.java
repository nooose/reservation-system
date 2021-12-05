package com.example.reservation.domain.entity;

import com.example.reservation.domain.type.ReviewRatingType;
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

    @OneToOne(mappedBy = "review", fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    private ReviewRatingType reviewRating;

    @CreatedDate
    private LocalDateTime createAt;

    @Builder
    public Review(Long id, String contents, Order order, ReviewRatingType reviewRating, LocalDateTime createAt) {
        this.id = id;
        this.contents = contents;
        this.order = order;
        this.reviewRating = reviewRating;
        this.createAt = createAt;
    }
}

