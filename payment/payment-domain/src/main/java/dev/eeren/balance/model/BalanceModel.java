package dev.eeren.balance.model;

import java.math.BigDecimal;

public record BalanceModel(
        Long id,
        Long userId,
        BigDecimal total
) {
}
