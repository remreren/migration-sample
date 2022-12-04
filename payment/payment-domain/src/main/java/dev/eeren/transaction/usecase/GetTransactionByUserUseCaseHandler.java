package dev.eeren.transaction.usecase;

import dev.eeren.transaction.model.TransactionModel;
import dev.eeren.transaction.port.TransactionPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainComponent
@RequiredArgsConstructor
public class GetTransactionByUserUseCaseHandler implements UseCaseHandler<List<TransactionModel>, GetTransactionByUserUseCase> {

    private final TransactionPort transactionPort;

    @Override
    public List<TransactionModel> handle(GetTransactionByUserUseCase useCase) {

        return transactionPort.getTransactionsByUserId(useCase.userId());

    }
}
