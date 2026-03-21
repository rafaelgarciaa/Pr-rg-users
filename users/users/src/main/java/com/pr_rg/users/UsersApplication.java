package com.pr_rg.users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner {

    @Value("${custom.log.message:Mensaje por defecto}")
    private String logMessage;

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(logMessage);
    }
}
