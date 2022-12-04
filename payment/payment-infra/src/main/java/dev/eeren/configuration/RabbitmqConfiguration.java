package dev.eeren.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

    @Bean
    public Queue transactionCreated() {

        return new Queue("transaction.created");

    }

    @Bean
    public MessageConverter jsonMessageConverter(){

        return new Jackson2JsonMessageConverter();

    }

}
