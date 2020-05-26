package com.vijay.learn.sbsecurity.services;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();
    T getById(Integer id);
    T saveOrUpdate(T domainObject);
    void delete(Integer id);
}
