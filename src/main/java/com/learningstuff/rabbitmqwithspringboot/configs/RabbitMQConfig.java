package com.learningstuff.rabbitmqwithspringboot.configs;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৪/১/২০
 * Time: ১২:০৩ PM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final RabbitMQConfigReader rabbitMQConfigReader;

    @Bean
    public TopicExchange getApp1Exchange() {
        return new TopicExchange(rabbitMQConfigReader.getApp1Exchange());
    }

    @Bean
    public Queue getApp1Queue() {
        return new Queue(rabbitMQConfigReader.getApp1Queue());
    }

    @Bean
    public Binding declareBindingApp1() {
        return BindingBuilder.bind(getApp1Queue()).to(getApp1Exchange()).with(rabbitMQConfigReader.getApp1RoutingKey());
    }

    @Bean
    public TopicExchange getApp2Exchange() {
        return new TopicExchange(rabbitMQConfigReader.getApp2Exchange());
    }

    @Bean
    public Queue getApp2Queue() {
        return new Queue(rabbitMQConfigReader.getApp2Queue());
    }

    @Bean
    public Binding declareBindingApp2() {
        return BindingBuilder.bind(getApp2Queue()).to(getApp2Exchange()).with(rabbitMQConfigReader.getApp2RoutingKey());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());

        return rabbitTemplate;
    }


//    @Bean
//    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//
//    @Bean
//    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//        factory.setMessageConverter(consumerJackson2MessageConverter());
//        return factory;
//    }
//
//    @Override
//    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
//        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
//    }

}
