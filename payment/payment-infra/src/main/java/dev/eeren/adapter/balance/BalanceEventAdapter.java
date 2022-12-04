package dev.eeren.adapter.balance;

import dev.eeren.balance.events.BalanceUpdateFailedEvent;
import dev.eeren.balance.events.BalanceUpdatedEvent;
import dev.eeren.balance.port.BalanceEventPort;
import dev.eeren.transaction.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceEventAdapter implements BalanceEventPort {

    private final RabbitTemplate template;

    @Bean
    public Queue balanceUpdatedQueue() {

        return new Queue("balance.updated");

    }

    @Bean
    public Queue balanceUpdateFailedQueue() {

        return new Queue("balance.update.failed");

    }

    @Override
    public void balanceUpdated(TransactionModel transaction) {

        template.convertAndSend("balance.updated", new BalanceUpdatedEvent(transaction));

    }

    @Override
    public void balanceUpdateFailed(TransactionModel transaction) {

        template.convertAndSend("balance.update.failed", new BalanceUpdateFailedEvent(transaction));

    }
}
