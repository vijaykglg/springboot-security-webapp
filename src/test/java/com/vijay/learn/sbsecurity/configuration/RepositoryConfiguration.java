package com.vijay.learn.sbsecurity.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.vijay.learn.sbsecurity.domain"})
@EnableJpaRepositories(basePackages = {"com.vijay.learn.sbsecurity.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
