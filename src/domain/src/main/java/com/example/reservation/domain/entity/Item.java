package com.example.reservation.domain.entity;

import com.example.reservation.domain.dto.ItemDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String title;

    private String contents;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Order> orders = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Review> reviews = new ArrayList<>();


    @Column(columnDefinition = "TIME")
    private LocalTime startTime;

    @Column(columnDefinition = "TIME")
    private LocalTime endTime;
    @CreatedDate
    private LocalDateTime createAt;

    public ItemDto toDto() {
        ItemDto itemDto = new ItemDto();
        itemDto.setTitle(this.title);
        itemDto.setContents(this.contents);

        return itemDto;
    }

    @Builder
    public Item(Long id, String title, String contents, int price, Company company, List<Order> orders, LocalTime startTime, LocalTime endTime, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.price = price;
        this.company = company;
        this.orders = orders;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createAt = createAt;
    }

    public Item(String title, String contents, int price, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.contents = contents;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setCompany(Company company) {
        this.company = company;
        company.addItem(this);
    }
}
