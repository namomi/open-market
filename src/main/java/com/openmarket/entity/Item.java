package com.openmarket.entity;

import com.openmarket.constant.ItemSellStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@ToString
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                        // 상품 코드
    @Column(nullable = false, length = 50)
    private final String itemNm;                  // 상품명
    @Column(name = "price", nullable = false)
    private final int price;                      // 가격
    @Column(nullable = false)
    private final int stockNumber;                // 재고 수량
    @Lob
    @Column(nullable = false)
    private final String itemDetail;              // 상품 상세 설명
    @Enumerated(EnumType.STRING)
    private final ItemSellStatus itemSellStatus;  // 상품 판매 상태
    private final LocalDateTime regTime;          // 등록 시간
    private final LocalDateTime updateTime;       // 수정 시간
}


