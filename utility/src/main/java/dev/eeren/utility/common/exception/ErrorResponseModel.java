package dev.eeren.utility.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ErrorResponseModel {

    private final String traceId;

    private final ErrorDetail detail;

    private final String exception;

    private final LocalDateTime occurredAt;

}
