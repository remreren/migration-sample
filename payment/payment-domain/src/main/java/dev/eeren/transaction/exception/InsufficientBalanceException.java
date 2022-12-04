package dev.eeren.transaction.exception;

import dev.eeren.common.exception.BaseException;
import dev.eeren.common.exception.ErrorEnum;

public class InsufficientBalanceException extends BaseException {

    public InsufficientBalanceException(Long userId) {
        super(ErrorEnum.INSUFFICIENT_BALANCE, userId);
    }
}
