package com.example.reservation.service.impl;

import com.example.reservation.domain.dto.ReviewDto;
import com.example.reservation.domain.entity.Order;
import com.example.reservation.domain.entity.Review;
import com.example.reservation.domain.service.ReviewDomainService;
import com.example.reservation.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final OrderServiceImpl orderService;
    private final ReviewDomainService reviewDomainService;

    @Override
    @Transactional
    public Review createReview(Long orderId, ReviewDto reviewDto) {
        Order findOrder = orderService.getOrderById(orderId);


        Review review = new Review();
        review.setOrder(findOrder);
        review.setContents(reviewDto.getContents());
        review.setReviewRating(reviewDto.getReviewRatingType());
        review.setItem(findOrder.getItem());
        findOrder.setReview(review);


        return reviewDomainService.saveReview(review);
    }

    @Override
    public Review getReview(Long orderId) {
        return reviewDomainService.getReviewByOrderId(orderId);
    }
}
