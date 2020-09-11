package com.cars24.auction.repository;

/*
 *
 * @created 10/09/2020
 * @author ashok.kulhari@gmail.com
 *
 */

import com.cars24.auction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
