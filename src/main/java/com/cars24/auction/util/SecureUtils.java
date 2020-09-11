package com.cars24.auction.util;

import com.cars24.auction.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecureUtils {


    public static User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getPrincipal() = "+authentication.getPrincipal());
        return (User)authentication.getPrincipal();
    }




}
