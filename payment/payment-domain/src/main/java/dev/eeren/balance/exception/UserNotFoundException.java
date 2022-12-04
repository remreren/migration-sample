package dev.eeren.balance.exception;

import dev.eeren.utility.common.exception.BaseException;
import dev.eeren.utility.common.exception.ErrorEnum;
import lombok.Getter;

@Getter
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(Long userId) {
        super(ErrorEnum.USER_NOT_FOUND, userId);
    }
}
