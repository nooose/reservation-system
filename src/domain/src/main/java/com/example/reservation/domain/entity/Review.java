package com.example.reservation.domain.entity;

import com.example.reservation.domain.dto.api.ReviewDto;
import com.example.reservation.domain.type.ReviewRatingType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Setter
    private String contents;

    @Setter
    @OneToOne(mappedBy = "review", fetch = FetchType.LAZY)
    private Order order;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @Setter
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

    public ReviewDto toDto() {
        return new ReviewDto(this.contents, this.reviewRating);
    }
}

