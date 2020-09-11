package com.cars24.auction.util;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import com.cars24.auction.entity.Auction;
import com.cars24.auction.model.AuctionDto;

public class EntityToDto {
    public static AuctionDto fromAction(Auction auction) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setItemCode(auction.getItemCode());
        auctionDto.setStepRate(auction.getStepRate());
        auctionDto.setHighestBigAmount(auction.getLastBidAmount());
        return auctionDto;
    }
}
