package dev.eeren.transaction.usecase;

import dev.eeren.transaction.port.TransactionEventPort;
import dev.eeren.transaction.port.TransactionPort;
import dev.eeren.utility.common.usecase.VoidUseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class TransactionRollbackUseCaseHandler implements VoidUseCaseHandler<TransactionRollbackUseCase> {

    private final TransactionPort transactionPort;

    private final TransactionEventPort transactionEventPort;

    @Override
    public void handle(TransactionRollbackUseCase useCase) {

        transactionPort.deleteTransaction(useCase.transaction().id());

        transactionEventPort.transactionRolledBack(useCase.transaction());

    }

}
