package com.example.api_ex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ApiEx2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiEx2Application.class, args);
    }

}
