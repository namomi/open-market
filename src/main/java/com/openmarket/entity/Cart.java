package com.openmarket.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
