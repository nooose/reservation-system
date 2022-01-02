package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.dto.api.ItemDto;
import com.example.reservation.domain.dto.api.ResponseCompanyDto;
import com.example.reservation.domain.type.CompanyCategoryType;
import com.example.reservation.domain.type.MemberRoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter
public class Company extends Member{

    private String registrationNumber;
    private String description;
    private String companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CompanyCategoryType companyCategory;

    @Builder
    public Company(Long id, String email, String password,
                   String nickName, String name, String phoneNumber, Address address,
                   MemberRoleType memberRole, List<Board> boards,
                   LocalDateTime createdAt, LocalDateTime lastLogin,
                   String registrationNumber, String description,
                   String companyName, CompanyCategoryType companyCategory) {

        super(id, email, password, nickName, name, phoneNumber, address, memberRole, boards, createdAt, lastLogin);
        this.registrationNumber = registrationNumber;
        this.description = description;
        this.companyName = companyName;
        this.companyCategory = companyCategory;
    }

    public ResponseCompanyDto toResponseDto() {
        ResponseCompanyDto responseCompanyDto = new ResponseCompanyDto();
        responseCompanyDto.setCompanyName(this.getCompanyName());
        responseCompanyDto.setName(this.getName());

        List<ItemDto> collect = this.getItems().stream()
                .map(Item::toDto)
                .collect(Collectors.toList());
        responseCompanyDto.setItems(collect);

        return responseCompanyDto;
    }

    public void changeCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
