package dev.eeren.adapter.transaction.dto;

import java.math.BigDecimal;

public record CreateTransactionRequest(
        Long userId,
        BigDecimal amount
) {

}
