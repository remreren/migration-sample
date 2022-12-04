package dev.eeren.transaction.usecase;

import dev.eeren.transaction.enums.TransactionType;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionEventPort;
import dev.eeren.transaction.port.TransactionPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreateDebtUseCaseHandler implements UseCaseHandler<TransactionModel, CreateDebtUseCase> {

    private final TransactionPort transactionPort;

    private final TransactionEventPort transactionEventPort;

    @Override
    public TransactionModel handle(CreateDebtUseCase debt) {

        var transaction = transactionPort.createTransaction(new TransactionModel(null, debt.userId(), TransactionType.DEBT, debt.amount(), null));

        transactionEventPort.transactionCreated(transaction);

        return transaction;

    }
}
