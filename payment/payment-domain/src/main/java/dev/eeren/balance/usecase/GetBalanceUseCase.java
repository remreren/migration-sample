package dev.eeren.balance.usecase;

import dev.eeren.utility.common.model.UseCase;

public record GetBalanceUseCase(Long userId) implements UseCase {
}
