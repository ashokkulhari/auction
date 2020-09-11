package com.cars24.auction.service;

import com.cars24.auction.Exception.ApplicationException;
import com.cars24.auction.entity.Auction;
import com.cars24.auction.entity.Bid;
import com.cars24.auction.model.BidDto;
import com.cars24.auction.repository.AuctionRepository;
import com.cars24.auction.repository.BidRepository;
import com.cars24.auction.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */
@Service
@Transactional
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private BidRepository bidRepository;

    public Page<Auction> getByStatus(String status, Pageable pageable) {
        return auctionRepository.findAllByStatus(status, pageable);
    }

    public Auction save(Auction auction){
        return auctionRepository.save(auction);
    }

    public void createBid(String itemCode, BidDto bidDto) {
        Auction auction  = auctionRepository.findByItemCode(itemCode)
                .orElseThrow(()-> new ApplicationException("Auction not found",HttpStatus.NOT_FOUND));

        if(bidDto.getAmount() <= auction.getMinBasePrice()
                || ( bidDto.getAmount() <= (auction.getLastBidAmount()+ auction.getStepRate()))  ){
            throw new ApplicationException("Bid is rejected",HttpStatus.NOT_ACCEPTABLE);
        }

        Bid bid = new Bid();
        bid.setAmount(bidDto.getAmount());
        bid.setUser(SecureUtils.getCurrentUser());
        bid = bidRepository.save(bid);
        List<Bid> bids  =auction.getBids();
        if(bids==null){
            bids  = new ArrayList<>();
        }
        bids.add(bid);
        auction.setLastBidAmount(bidDto.getAmount());
        auctionRepository.save(auction);
    }
}
