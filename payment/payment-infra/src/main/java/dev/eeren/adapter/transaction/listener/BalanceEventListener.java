package dev.eeren.adapter.transaction.listener;

import dev.eeren.balance.events.BalanceUpdateFailedEvent;
import dev.eeren.transaction.usecase.TransactionRollbackUseCase;
import dev.eeren.utility.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BalanceEventListener {

    private final VoidUseCaseHandler<TransactionRollbackUseCase> transactionRollbackUseCaseHandler;

    @RabbitListener(queues = "balance.update.failed", id = "transaction.rollback")
    public void rollbackTransaction(BalanceUpdateFailedEvent balanceUpdateFailed) {

        transactionRollbackUseCaseHandler.handle(new TransactionRollbackUseCase(balanceUpdateFailed.transaction()));

    }

}
