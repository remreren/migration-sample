package dev.eeren.transaction.usecase;

import dev.eeren.utility.common.model.UseCase;

public record GetTransactionByUserUseCase(Long userId) implements UseCase {
}
