package dev.eeren.transaction.model;

import dev.eeren.transaction.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

public record TransactionModel(
        Long id,
        Long userId,
        TransactionType type,
        BigDecimal amount,
        Date createdAt
) {

    public BigDecimal amount() {
        return type.equals(TransactionType.DEBT) ? amount : amount.negate();
    }
}
