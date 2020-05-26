package com.vijay.learn.sbsecurity.services;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.sbsecurity.domain.User;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
}
