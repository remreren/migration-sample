package dev.eeren.adapter.transaction;

import dev.eeren.transaction.events.RollbackTransactionEvent;
import dev.eeren.transaction.events.TransactionCreatedEvent;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionEventPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionEventAdapter implements TransactionEventPort {

    private final RabbitTemplate rabbitTemplate;

    @Bean
    public Queue transactionCreatedQueue() {

        return new Queue("transaction.created");

    }

    @Bean
    public Queue transactionRollback() {

        return new Queue("transaction.rollback");

    }

    public void transactionCreated(TransactionModel transaction) {

        rabbitTemplate.convertAndSend("transaction.created", new TransactionCreatedEvent(transaction));

    }

    @Override
    public void transactionRolledBack(TransactionModel transaction) {

        rabbitTemplate.convertAndSend("transaction.rollback", new RollbackTransactionEvent(transaction));

    }

}
