package com.example.reservation.domain.dto;

import com.example.reservation.domain.entity.Item;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {
    private String title;
    private String contents;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createAt;


    public Item toEntity() {
        return createItem(this.title, this.contents, this.startTime, this.endTime);
    }

    private Item createItem(String title, String contents,
                            LocalDateTime startTime, LocalDateTime endTime) {
        return Item.builder()
                .title(title).contents(contents)
                .startTime(startTime).endTime(endTime)
                .build();
    }
}
