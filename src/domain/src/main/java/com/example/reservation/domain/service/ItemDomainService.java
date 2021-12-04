package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Item;
import com.example.reservation.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ItemDomainService {
    private final ItemRepository itemRepository;

    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException("특정 아이템이 없습니다."));
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void removeItem(Item item) {
        itemRepository.delete(item);
    }
}
