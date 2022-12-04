package dev.eeren.account.port;

import dev.eeren.account.model.AccountModel;
import dev.eeren.utility.common.util.DomainComponent;

import java.util.Optional;

@DomainComponent
public interface AccountPort {

    Optional<AccountModel> getAccountById(Long accountId);

}
