package com.cars24.auction.repository;

import com.cars24.auction.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */
@Repository
public interface AuctionRepository  extends JpaRepository<Auction, Long> {

    Page<Auction> findAllByStatus(String status,Pageable pageable);

    Optional<Auction> findByItemCode(String itemCode);
}
