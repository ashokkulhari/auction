package com.cars24.auction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */
@Entity
@Getter
@Setter
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
