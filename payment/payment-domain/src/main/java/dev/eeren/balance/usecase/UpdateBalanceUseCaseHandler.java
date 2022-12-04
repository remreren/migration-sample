package dev.eeren.balance.usecase;

import dev.eeren.balance.exception.UserNotFoundException;
import dev.eeren.balance.port.BalanceEventPort;
import dev.eeren.balance.port.BalancePort;
import dev.eeren.transaction.exception.InsufficientBalanceException;
import dev.eeren.utility.common.usecase.VoidUseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@DomainComponent
@RequiredArgsConstructor
public class UpdateBalanceUseCaseHandler implements VoidUseCaseHandler<UpdateBalanceUseCase> {

    private final BalancePort balancePort;

    private final BalanceEventPort balanceEventPort;

    @Override
    public void handle(UpdateBalanceUseCase useCase) {

        var userBalance = balancePort.getUserBalance(useCase.transaction().userId())
                                     .orElseThrow(() -> new UserNotFoundException(useCase.transaction().userId()));

        if (isNegative(userBalance.total().add(useCase.transaction().amount()))) {

            balanceEventPort.balanceUpdateFailed(useCase.transaction());

            throw new InsufficientBalanceException(useCase.transaction().userId());

        }

        balanceEventPort.balanceUpdated(useCase.transaction());

        balancePort.updateBalance(useCase.transaction());

    }

    private boolean isNegative(BigDecimal value) {

        return value.compareTo(BigDecimal.ZERO) < 0;

    }

}
