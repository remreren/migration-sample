package dev.eeren.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ErrorMessagesConfiguration {

    @Bean
    public MessageSource messageSource() {

        final var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/api_error_messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;

    }
}
