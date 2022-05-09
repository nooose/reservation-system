package com.example.reservation.domain.dto;

import com.example.reservation.domain.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ItemDto {
    private String title;
    private String contents;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDateTime createAt;


    public Item toEntity() {
        return createItem(this.title, this.contents, this.startTime, this.endTime);
    }

    private Item createItem(String title, String contents,
                            LocalTime startTime, LocalTime endTime) {
        return Item.builder()
                .title(title).contents(contents)
                .startTime(startTime).endTime(endTime)
                .build();
    }
}
