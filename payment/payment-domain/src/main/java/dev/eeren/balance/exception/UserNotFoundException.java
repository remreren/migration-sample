package dev.eeren.balance.exception;

import dev.eeren.common.exception.BaseException;
import dev.eeren.common.exception.ErrorEnum;
import lombok.Getter;

@Getter
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(Long userId) {
        super(ErrorEnum.USER_NOT_FOUND, userId);
    }
}
