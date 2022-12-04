package dev.eeren.transaction.exception;

import dev.eeren.utility.common.exception.BaseException;
import dev.eeren.utility.common.exception.ErrorEnum;

public class InsufficientBalanceException extends BaseException {

    public InsufficientBalanceException(Long userId) {
        super(ErrorEnum.INSUFFICIENT_BALANCE, userId);
    }
}
