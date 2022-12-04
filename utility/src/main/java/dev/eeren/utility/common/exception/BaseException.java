package dev.eeren.utility.common.exception;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class BaseException extends RuntimeException implements Supplier<BaseException> {

    private final ErrorEnum errorEnum;

    private final Object[] args;

    public BaseException(ErrorEnum errorEnum, Object... args) {
        this.errorEnum = errorEnum;
        this.args = args;
    }


    @Override
    public BaseException get() {
        return this;
    }
}
