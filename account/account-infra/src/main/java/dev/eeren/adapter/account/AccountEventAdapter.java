package dev.eeren.adapter.account;

import dev.eeren.account.events.AccountCreatedEvent;
import dev.eeren.account.model.AccountModel;
import dev.eeren.account.port.AccountEventPort;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountEventAdapter implements AccountEventPort {

    private final RabbitTemplate template;

    @Bean
    public Queue accountCreatedQueue() {

        return new Queue("account.created");

    }

    @Override
    public void accountCreated(AccountModel account) {

        template.convertAndSend("account.created", new AccountCreatedEvent(account));

    }

}
