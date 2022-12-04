package dev.eeren.transaction.usecase;

import dev.eeren.utility.common.model.UseCase;

public record GetTransactionByIdUseCase(Long id) implements UseCase {
}
