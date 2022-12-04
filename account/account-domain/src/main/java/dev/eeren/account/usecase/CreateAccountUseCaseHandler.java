package dev.eeren.account.usecase;

import dev.eeren.account.model.AccountModel;
import dev.eeren.account.port.AccountEventPort;
import dev.eeren.account.port.AccountPort;
import dev.eeren.utility.common.usecase.UseCaseHandler;
import dev.eeren.utility.common.util.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreateAccountUseCaseHandler implements UseCaseHandler<AccountModel, CreateAccountUseCase> {

    private final AccountPort accountPort;

    private final AccountEventPort accountEventPort;

    @Override
    public AccountModel handle(CreateAccountUseCase useCase) {

        var account = accountPort.createAccount(useCase.account());

        accountEventPort.accountCreated(account);

        return account;

    }

}
