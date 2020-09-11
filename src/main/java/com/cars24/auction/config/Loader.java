package com.cars24.auction.config;

import com.cars24.auction.entity.Auction;
import com.cars24.auction.entity.AuctionStatus;
import com.cars24.auction.entity.User;
import com.cars24.auction.repository.AuctionRepository;
import com.cars24.auction.repository.UserRepository;
import com.cars24.auction.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;


//@Component
public class Loader {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuctionRepository auctionRepository;

    @PostConstruct
    public void loadTestUser(){
        Optional<User> userOptional = userRepository.findByUserName(Constants.TEST_USERNAME);
        if(!userOptional.isPresent()){
            User user = new User();
            user.setUserName(Constants.TEST_USERNAME);
            user.setPassword(passwordEncoder.encode(Constants.TEST_USERNAME));
            userRepository.save(user);
        }

        Auction auction =new Auction();
        auction.setStepRate(250);
        auction.setItemCode("1111");
        auction.setMinBasePrice(1000);
        auction.setLastBidAmount(1000);
        auction.setStatus(AuctionStatus.RUNNING.toString());
        auctionRepository.save(auction);

    }
}
