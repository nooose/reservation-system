package com.example.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("I")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Item extends Board{

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "time", joinColumns = @JoinColumn(name = "item_id"))
    private List<LocalDateTime> timeList = new ArrayList<>();

    @Builder
    public Item(Long id, String title, String contents, Member member, String category, LocalDateTime createdAt, Company company, List<Order> orders, List<LocalDateTime> timeList) {
        super(id, title, contents, member, category, createdAt);
        this.company = company;
        this.orders = orders;
        this.timeList = timeList;
    }
}
