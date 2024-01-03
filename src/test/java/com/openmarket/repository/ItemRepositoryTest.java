package com.openmarket.repository;

import com.openmarket.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static com.openmarket.constant.ItemSellStatus.SELL;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void createdItemList(){
        Item item = new Item("테스트 상품", 10000, 100,"테스트 상품 상세 설명",
                SELL, LocalDateTime.now(), LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        assertThat(savedItem).isEqualTo(item);
    }

    @Test
    public void findByItemNeTest(){
        //given
        this.createdItemList();

        //when
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품");

        //then
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

}