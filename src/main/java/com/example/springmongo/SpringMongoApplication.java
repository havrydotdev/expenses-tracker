package com.example.springmongo;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }
}
