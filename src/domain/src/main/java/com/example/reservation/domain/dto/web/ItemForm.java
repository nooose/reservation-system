package com.example.reservation.domain.dto.web;

import com.example.reservation.domain.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ItemForm {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
    @NotBlank
    private int price;
    @NotBlank
    private LocalTime startTime;
    @NotBlank
    private LocalTime endTime;

    public Item toEntity() {
        return new Item(title, contents, price, startTime, endTime);
    }
}
