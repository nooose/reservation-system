package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Review;
import com.example.reservation.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReviewDomainService {

    private final ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review getReview(Long reviewId) {
        Optional<Review> byId = reviewRepository.findById(reviewId);
        return byId.orElseThrow(() -> new IllegalStateException("해당하는 리뷰가 없습니다."));
    }

    public Review getReviewByOrderId(Long orderId) {
        Optional<Review> reviewByOrderId = reviewRepository.getReviewByOrderId(orderId);
        return reviewByOrderId.orElseThrow(() -> new IllegalStateException("해당하는 리뷰가 없습니다."));
    }
}
