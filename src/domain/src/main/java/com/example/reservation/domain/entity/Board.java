package com.example.reservation.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String contents;

    private Member writer;

    private String category;

    @CreatedDate
    private LocalDateTime createdAt;

}
