package com.example.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("N")
@NoArgsConstructor
@Getter
public class Notice extends Board{

    @Builder
    public Notice(Long id, String title, String contents, Member member, String category, LocalDateTime createdAt) {
        super(id, title, contents, member, category, createdAt);
    }
}
