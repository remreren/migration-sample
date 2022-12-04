package dev.eeren.transaction.exception;

import dev.eeren.common.exception.BaseException;
import dev.eeren.common.exception.ErrorEnum;

public class TransactionNotFoundException extends BaseException {

    public TransactionNotFoundException(Long transactionId) {
        super(ErrorEnum.TRANSACTION_NOT_FOUND, transactionId);
    }
}
