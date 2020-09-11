package com.cars24.auction.entity;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
public class Auction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemCode;

    private Integer minBasePrice;

    private Integer stepRate;

    private Integer lastBidAmount;

    private String status;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Bid> bids;
}
