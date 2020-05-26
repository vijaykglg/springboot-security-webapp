package com.vijay.learn.sbsecurity.services.security;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

public interface EncryptionService {
    String encryptString(String input);

    boolean checkPassword(String plainPassword, String encryptedPassword);
}
