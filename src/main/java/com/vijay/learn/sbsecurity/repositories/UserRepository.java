package com.vijay.learn.sbsecurity.repositories;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.sbsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
