package com.example.reservation.controller.api;


import com.example.reservation.domain.dto.api.ReviewDto;
import com.example.reservation.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{orderId}")
    public ReviewDto createReview(@PathVariable Long orderId,
                             @RequestBody @Valid ReviewDto reviewDto) {

        return reviewService.createReview(orderId, reviewDto).toDto();
    }

    @GetMapping("/{orderId}")
    public ReviewDto getReview(@PathVariable Long orderId) {
        return reviewService.getReview(orderId).toDto();
    }

}
