package dev.eeren.account.port;

import dev.eeren.account.model.AccountModel;
import dev.eeren.utility.common.util.DomainComponent;

@DomainComponent
public interface AccountEventPort {

    void accountCreated(AccountModel account);

}
