package dev.eeren.balance.usecase;

import dev.eeren.utility.common.model.UseCase;

public record CreateBalanceUseCase(Long userId) implements UseCase {
}
