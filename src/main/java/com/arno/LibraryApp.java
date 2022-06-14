package com.arno;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

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

        try{
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
