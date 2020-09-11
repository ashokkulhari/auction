package com.cars24.auction.model;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {

    private String itemCode;

    private Integer highestBigAmount;

    private Integer stepRate;
}
