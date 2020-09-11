package com.cars24.auction.repository;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import com.cars24.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
