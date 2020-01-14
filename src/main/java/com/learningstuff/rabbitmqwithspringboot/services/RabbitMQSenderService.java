package com.learningstuff.rabbitmqwithspringboot.services;

import com.learningstuff.rabbitmqwithspringboot.configs.RabbitMQConfigReader;
import com.learningstuff.rabbitmqwithspringboot.models.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৪/১/২০
 * Time: ১১:৫৮ AM
 * Email: mdshamim723@gmail.com
 */

@Slf4j
@AllArgsConstructor
@Service
public class RabbitMQSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConfigReader rabbitMQConfigReader;

    @Scheduled(fixedDelay = 3000L)
    public void sendStudentOne() {

        Student student = new Student("First", "Math", 4);
        rabbitTemplate.convertAndSend(rabbitMQConfigReader.getApp1Exchange(), rabbitMQConfigReader.getApp1RoutingKey(), student);
        log.info("First student send");
    }

    @Scheduled(fixedDelay = 7000L)
    public void setStudentTwo() {

        Student student = new Student("Second", "Math", 3.8);
        rabbitTemplate.convertAndSend(rabbitMQConfigReader.getApp2Exchange(), rabbitMQConfigReader.getApp2RoutingKey(), student);
        log.info("Second student send");
    }

}
