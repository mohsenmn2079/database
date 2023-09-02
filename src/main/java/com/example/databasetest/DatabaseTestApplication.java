package com.example.databasetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DatabaseTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseTestApplication.class, args);
    }

}
