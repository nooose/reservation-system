package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private int price;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToOne
    @JoinColumn(name="review_id")
    private Review review;


    @ManyToOne
    @JoinColumn(name= "item_id")
    private Item item;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreatedDate
    private LocalDateTime createdAt;


    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
