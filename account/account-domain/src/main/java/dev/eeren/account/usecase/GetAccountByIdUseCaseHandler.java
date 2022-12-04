package dev.eeren.account.usecase;

import dev.eeren.account.exception.AccountNotFoundException;
import dev.eeren.account.model.AccountModel;
import dev.eeren.account.port.AccountPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class GetAccountByIdUseCaseHandler implements UseCaseHandler<AccountModel, GetAccountByIdUseCase> {

    private final AccountPort accountPort;

    @Override
    public AccountModel handle(GetAccountByIdUseCase useCase) {

        return accountPort.getAccountById(useCase.accountId()).orElseThrow(() -> new AccountNotFoundException(useCase.accountId()));

    }

}
