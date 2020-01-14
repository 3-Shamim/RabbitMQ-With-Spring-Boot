package com.learningstuff.rabbitmqwithspringboot.listeners;

import com.learningstuff.rabbitmqwithspringboot.models.SimplifiedStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৪/১/২০
 * Time: ৩:০১ PM
 * Email: mdshamim723@gmail.com
 */

@Slf4j
@Service
public class StudentListener {

//    @RabbitListener(queues = "${app1.queue.name}")
//    public void consumeDefaultMessage(final Message message) {
//        log.info("Received message with default config {}", message.toString());
//    }
//
//    @RabbitListener(queues = "${app1.queue.name}")
//    public void consumeDefaultMessage(final Student message) {
//        log.info("Received message with default class path config {}", message.toString());
//    }

    /* Note
     * User deserializer for customer class path
     * Need converter for this
     * */
//    @RabbitListener(queues = "${app1.queue.name}")
//    public void consumeDefaultMessage(final StudentAnother message) {
//        log.info(message.getName());
//    }

    /* Note
     * User deserializer for customer class path
     * Need converter for this
     * */
    @RabbitListener(queues = "${app1.queue.name}")
    public void consumeFirstMessage(final SimplifiedStudent message) {
        log.info(message.getName());
    }

    /* Note
     * User deserializer for customer class path
     * Need converter for this
     * */
    @RabbitListener(queues = "${app2.queue.name}")
    public void consumeSecondMessage(final SimplifiedStudent message) {
        log.info(message.getName());
    }

}
