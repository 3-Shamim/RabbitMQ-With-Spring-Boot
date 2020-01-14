package com.learningstuff.rabbitmqwithspringboot.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৪/১/২০
 * Time: ২:০৮ PM
 * Email: mdshamim723@gmail.com
 */

@Configuration
@Getter
public class RabbitMQConfigReader {

    @Value("${app1.exchange.name}")
    private String app1Exchange;
    @Value("${app1.queue.name}")
    private String app1Queue;
    @Value("${app1.routing.key}")
    private String app1RoutingKey;
    @Value("${app2.exchange.name}")
    private String app2Exchange;
    @Value("${app2.queue.name}")
    private String app2Queue;
    @Value("${app2.routing.key}")
    private String app2RoutingKey;

}
