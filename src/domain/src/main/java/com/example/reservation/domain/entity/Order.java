package com.example.reservation.domain.entity;

import com.example.reservation.domain.dto.OrderDto;
import com.example.reservation.domain.type.OrderStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ORDER_TABLE")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Setter
    private int price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @Setter
    @Enumerated(EnumType.STRING)
    private OrderStatusType orderStatus;

    @CreatedDate
    private LocalDateTime createdAt;


    @Setter
    private LocalDateTime startTime;
    @Setter
    private LocalDateTime endTime;

    @Builder
    public Order(Long id, int price, User user, Review review, Item item, OrderStatusType orderStatus, LocalDateTime createdAt, LocalDateTime startTime, LocalDateTime endTime) {
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

    public Order() {
    }

    public OrderDto toResponseDto() {
        return new OrderDto(
                this.item.getTitle(),
                this.orderStatus,
                this.startTime, this.endTime);
    }

    public void setUser(User user) {
        this.user = user;
        user.getOrders().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getOrders().add(this);
    }
}
