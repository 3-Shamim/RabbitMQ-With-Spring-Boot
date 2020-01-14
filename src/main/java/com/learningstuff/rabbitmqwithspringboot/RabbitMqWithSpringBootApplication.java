package com.learningstuff.rabbitmqwithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqWithSpringBootApplication.class, args);
    }

}
