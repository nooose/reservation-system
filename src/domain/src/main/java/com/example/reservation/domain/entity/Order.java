package com.example.reservation.domain.entity;

import com.example.reservation.domain.enumtype.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ORDER_TABLE")
@NoArgsConstructor
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
    @JoinColumn(name = "review_id")
    private Review review;


    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreatedDate
    private LocalDateTime createdAt;


    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Builder
    public Order(Long id, int price, User user, Review review, Item item, OrderStatus orderStatus, LocalDateTime createdAt, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.price = price;
        this.user = user;
        this.review = review;
        this.item = item;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
