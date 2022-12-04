package dev.eeren.transaction.usecase;

import dev.eeren.utility.common.model.UseCase;

import java.math.BigDecimal;

public record CreateDebtUseCase(
        Long userId,
        BigDecimal amount
) implements UseCase {
}
