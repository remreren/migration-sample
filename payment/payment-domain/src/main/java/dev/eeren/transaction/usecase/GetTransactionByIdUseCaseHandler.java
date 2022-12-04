package dev.eeren.transaction.usecase;

import dev.eeren.transaction.exception.TransactionNotFoundException;
import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetTransactionByIdUseCaseHandler implements UseCaseHandler<TransactionModel, GetTransactionByIdUseCase> {

    private final TransactionPort transactionPort;

    @Override
    public TransactionModel handle(GetTransactionByIdUseCase useCase) {

        return transactionPort.getTransaction(useCase.id())
                              .orElseThrow(() -> new TransactionNotFoundException(useCase.id()));

    }
}
