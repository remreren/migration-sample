package dev.eeren.account.usecase;

import dev.eeren.utility.common.model.UseCase;

public record GetAccountByIdUseCase(Long accountId) implements UseCase {
}
