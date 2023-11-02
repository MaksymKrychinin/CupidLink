package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}

