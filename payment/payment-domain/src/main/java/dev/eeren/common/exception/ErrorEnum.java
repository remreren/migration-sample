package dev.eeren.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorEnum {

    UNEXPECTED_ERROR("unexpected.error", 500),
    USER_NOT_FOUND("user.not.found", 404),
    TRANSACTION_NOT_FOUND("transaction.not.found", 404),
    INSUFFICIENT_BALANCE("insufficient.balance", 400);

    private final String messageKey;

    private final Integer code;

}
