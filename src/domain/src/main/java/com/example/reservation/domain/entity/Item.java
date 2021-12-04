package com.example.reservation.domain.entity;

import com.example.reservation.domain.dto.ItemDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Column(name = "item_id")
    private Long id;

    private String title;

    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();


    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @CreatedDate
    private LocalDateTime createAt;

    public ItemDto toDto() {
        ItemDto itemDto = new ItemDto();
        itemDto.setTitle(this.title);
        itemDto.setContents(this.contents);

        return itemDto;
    }

    @Builder
    public Item(Long id, String title, String contents, Company company, List<Order> orders, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.company = company;
        this.orders = orders;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createAt = createAt;
    }

}
