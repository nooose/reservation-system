package com.example.reservation.domain.dto.api;

import com.example.reservation.domain.type.ReviewRatingType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ReviewDto {
    @NotBlank
    private String contents;

    private ReviewRatingType reviewRatingType;

}
