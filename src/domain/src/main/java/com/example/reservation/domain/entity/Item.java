package com.example.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_id")
    private Long id;

    private String title;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "time", joinColumns = @JoinColumn(name = "item_id"))
    private List<LocalDateTime> timeList = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createAt;


    @Builder
    public Item(Long id, String title, String contents, Company company, List<Order> orders, List<LocalDateTime> timeList, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.company = company;
        this.orders = orders;
        this.timeList = timeList;
        this.createAt = createAt;
    }
}
