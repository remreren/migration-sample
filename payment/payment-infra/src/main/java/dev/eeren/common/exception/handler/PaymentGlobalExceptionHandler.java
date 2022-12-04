package dev.eeren.common.exception.handler;

import brave.Tracer;
import dev.eeren.common.exception.BaseException;
import dev.eeren.common.exception.ErrorDetail;
import dev.eeren.common.exception.ErrorEnum;
import dev.eeren.common.exception.ErrorResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class PaymentGlobalExceptionHandler {

    private final Tracer tracer;

    private final MessageSource messageSource;

    @ExceptionHandler(BaseException.class)
    private ResponseEntity<ErrorResponseModel> handle(BaseException exception) {

        var traceId = tracer.currentSpan().context().traceIdString();
        log.error("TraceID : {} -- Exception occurred.", traceId, exception);

        var message = messageSource.getMessage(exception.getErrorEnum().getMessageKey(), exception.getArgs(), "A baseexception error occurred!!!", Locale.ENGLISH);
        var detail = new ErrorDetail(message);
        var response = new ErrorResponseModel(traceId, detail, exception.getClass().getSimpleName(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.valueOf(exception.getErrorEnum().getCode()));

    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponseModel> handle(Exception exception) {

        var traceId = tracer.currentSpan().context().traceIdString();
        log.error("TraceID : {} -- Exception occurred.", traceId, exception);

        var message = messageSource.getMessage(ErrorEnum.UNEXPECTED_ERROR.getMessageKey(), null, "A unexpected error occurred!!!", Locale.ENGLISH);
        var detail = new ErrorDetail(message);
        var response = new ErrorResponseModel(traceId, detail, exception.getClass().getSimpleName(), LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorEnum.UNEXPECTED_ERROR.getCode()));

    }

}
