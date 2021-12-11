package com.example.reservation.service;


import com.example.reservation.domain.dto.ReviewDto;
import com.example.reservation.domain.entity.Review;

public interface ReviewService {
    Review createReview(Long orderId, ReviewDto reviewDto);
    Review getReview(Long orderId);
}
