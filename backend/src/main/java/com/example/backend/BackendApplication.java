package com.example.backend;

import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    @Autowired
    ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            UserRepository bean = applicationContext.getBean(UserRepository.class);
            System.out.println(bean.userWithIdIsFriendOfUserWithId(2L, 1L));
        };
    }
}

