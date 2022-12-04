package dev.eeren.adapter.balance.listener;

import dev.eeren.balance.usecase.UpdateBalanceUseCase;
import dev.eeren.transaction.events.TransactionCreatedEvent;
import dev.eeren.utility.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionEventListener {

    private final VoidUseCaseHandler<UpdateBalanceUseCase> updateBalanceUseCaseHandler;

    @RabbitListener(queues = "transaction.created", id = "update.balance")
    public void updateBalanceListener(TransactionCreatedEvent transactionCreated) {

        updateBalanceUseCaseHandler.handle(new UpdateBalanceUseCase(transactionCreated.transaction()));

    }

}
