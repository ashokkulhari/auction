package com.cars24.auction.controller;

import com.cars24.auction.entity.Auction;
import com.cars24.auction.model.BidDto;
import com.cars24.auction.service.AuctionService;
import com.cars24.auction.util.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */
@RestController
@RequestMapping(path = "/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping(value = {""})
    public ResponseEntity<?> getByStatus(@RequestParam(value = "status") String status, Pageable pageable) {
        Page<Auction> auctionPage  = auctionService.getByStatus(status, pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(auctionPage.map(EntityToDto::fromAction));
    }

    @PostMapping(path = "/{itemCode}/bid")
    @ResponseStatus( HttpStatus.CREATED )
    public void createBid(@PathVariable String itemCode, @RequestBody BidDto bidDto){
        auctionService.createBid(itemCode , bidDto);
    }
}
