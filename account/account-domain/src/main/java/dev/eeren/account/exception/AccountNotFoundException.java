package dev.eeren.account.exception;

import dev.eeren.utility.common.exception.BaseException;
import dev.eeren.utility.common.exception.ErrorEnum;

public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException(Long accountId) {
        super(ErrorEnum.ACCOUNT_NOT_FOUND, accountId);
    }
}
