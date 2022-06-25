package com.arno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Response Codes:
// 100 - Successful
// 99 - User not found
// 98 - Token expiration
// 97 - Empty source
// 0 - Bad request body

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
