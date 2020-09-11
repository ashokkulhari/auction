package com.cars24.auction;

import com.cars24.auction.entity.Auction;
import com.cars24.auction.entity.AuctionStatus;
import com.cars24.auction.model.BidDto;
import com.cars24.auction.repository.AuctionRepository;
import com.cars24.auction.service.AuctionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuctionApplicationTests {

	@Autowired
	private AuctionService auctionService;

	@Test
	void contextLoads() {
	}
	@Test
	void TestRunningAuction(){
		Auction auction = createAuction();

		assertEquals(1000, auction.getLastBidAmount());
}

	@Test
	void TestCreateBid(){
		Auction auction = createAuction();

		String itemCode = "1111";

		BidDto bidDto = new BidDto();
		bidDto.setAmount(1000);
		auctionService.createBid(itemCode, bidDto);

		assertEquals(1000, auction.getLastBidAmount());
	}

	private Auction createAuction() {
		Auction auction =new Auction();
		auction.setStepRate(250);
		auction.setItemCode("1111");
		auction.setMinBasePrice(1000);
		auction.setLastBidAmount(1000);
		auction.setStatus(AuctionStatus.RUNNING.toString());
		auction = auctionService.save(auction);
		return auction;
	}

}
