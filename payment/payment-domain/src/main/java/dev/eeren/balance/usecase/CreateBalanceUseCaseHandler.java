package dev.eeren.balance.usecase;

import dev.eeren.balance.model.BalanceModel;
import dev.eeren.balance.port.BalancePort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@DomainComponent
@RequiredArgsConstructor
public class CreateBalanceUseCaseHandler implements UseCaseHandler<BalanceModel, CreateBalanceUseCase> {

    private final BalancePort balancePort;

    @Override
    public BalanceModel handle(CreateBalanceUseCase useCase) {

        return balancePort.createBalance(new BalanceModel(null, useCase.userId(), BigDecimal.ZERO));

    }

}
