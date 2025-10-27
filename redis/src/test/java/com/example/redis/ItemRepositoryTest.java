package com.example.redis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("")
    @Test
    void createTest() {
        // given
        Item item = Item.builder()
                .id(1L)
                .name("item")
                .description("description")
                .price(100000)
                .build();

        // when
        itemRepository.save(item);

        // then
    }

    @DisplayName("")
    @Test
    void readOneTest() {
        Item item = itemRepository.findById(1L).orElseThrow();
        // given
        System.out.println(item.getDescription());
        // when//레디스 키를 구분하는 용도

        // then
    }

    @DisplayName("")
    @Test
    void updateTest() {
        // given
        Item item = itemRepository.findById(1L).orElseThrow();
        // when
        item.setDescription("new description");
        // then
        itemRepository.save(item);
    }
}