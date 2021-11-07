package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.ProcessType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("SC")
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class ServiceCenter extends Board{

    @Enumerated(EnumType.STRING)
    private ProcessType process;

    @Builder
    public ServiceCenter(Long id, String title, String contents, Member writer, String category, LocalDateTime createdAt, ProcessType process) {
        super(id, title, contents, writer, category, createdAt);
        this.process = process;
    }
}
