package dev.eeren.balance.usecase;

import dev.eeren.balance.exception.UserNotFoundException;
import dev.eeren.balance.model.BalanceModel;
import dev.eeren.balance.port.BalancePort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetBalanceUseCaseHandler implements UseCaseHandler<BalanceModel, GetBalanceUseCase> {

    private final BalancePort balancePort;

    @Override
    public BalanceModel handle(GetBalanceUseCase useCase) {

        return balancePort.getUserBalance(useCase.userId())
                          .orElseThrow(() -> new UserNotFoundException(useCase.userId()));

    }
}
